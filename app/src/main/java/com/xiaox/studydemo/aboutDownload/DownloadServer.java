package com.xiaox.studydemo.aboutDownload;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.xiaox.studydemo.R;
import com.xiaox.studydemo.aboutBinder.Service;

import java.io.File;

import static com.xiaox.studydemo.MainActivity.TAG;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/5/28
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class DownloadServer extends Service {

    String CHANNEL_ONE_ID = "com.xiaox.studydemo.aboutDownload";
    String CHANNEL_ONE_NAME = "Channel One";

    public DownloadTask downloadTask;

    public DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progess) {
            Log.i(TAG, "progess" + progess);
            getNotificationManager().notify(1, getNotification("Downloading...", progess));
        }

        @Override
        public void onPause() {
            downloadTask = null;
            Toast.makeText(DownloadServer.this, "暂停下载", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {
            downloadTask = null;
            stopForeground(true);
            Toast.makeText(DownloadServer.this, "取消下载", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFail() {
            downloadTask = null;
            //下载失败关闭前台通知
            stopForeground(true);
            Log.i(TAG,"onFail");
            getNotificationManager().notify(1, getNotification("下载失败", -1));
            Toast.makeText(DownloadServer.this, "下载失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            //下载成功关闭前台通知
            Log.i(TAG,"onSuccess");
            stopForeground(true);
            getNotificationManager().notify(1, getNotification("下载成功", -1));
            Toast.makeText(DownloadServer.this, "下载成功", Toast.LENGTH_SHORT).show();
        }
    };
    private String downloadUrl;

    private Notification getNotification(String title, int progess) {
        Intent intent = new Intent(this, DownloadActivty.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ONE_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .setContentTitle(title);
        if (progess > 0) {
            builder.setContentText(progess + "%");
            builder.setProgress(100, progess, false);
        }
        NotificationChannel notificationChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(CHANNEL_ONE_ID,
                    CHANNEL_ONE_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            getNotificationManager().createNotificationChannel(notificationChannel);
        }
        return builder.build();
    }

    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    private DownloadBinder binder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void onStart(String url) {
            if (downloadTask == null) {
                downloadUrl = url;
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(url);
                startForeground(1, getNotification("正在下载", 0));
                Toast.makeText(DownloadServer.this, "正在下载", Toast.LENGTH_SHORT).show();
            }
        }

        public void onPause() {
            if (downloadTask != null) {
                downloadTask.setPaused();
            }
        }

        public void onCancel() {
            if (downloadTask != null) {
                downloadTask.setCanceled();
            } else {
                if (downloadUrl != null) {
                    // 取消下载时需将文件删除，并将通知关闭
                    String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                    String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                    File file = new File(directory + fileName);
                    if (file.exists()) {
                        file.delete();
                    }
                    getNotificationManager().cancel(1);
                    stopForeground(true);
                    Toast.makeText(DownloadServer.this, "Canceled", Toast.LENGTH_SHORT).show();
                }
            }
        }


    }

}
