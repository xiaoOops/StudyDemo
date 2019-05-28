package com.xiaox.studydemo.aboutDownload;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.xiaox.studydemo.R;
import com.xiaox.studydemo.aboutBinder.Service;

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


    public DownloadTask downloadTask;

    public DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progess) {
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
            getNotificationManager().notify(1, getNotification("下载失败", -1));
            Toast.makeText(DownloadServer.this, "下载失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            //下载失败关闭前台通知
            stopForeground(true);
            getNotificationManager().notify(1, getNotification("下载成功", -1));
            Toast.makeText(DownloadServer.this, "下载成功", Toast.LENGTH_SHORT).show();
        }
    };

    private Notification getNotification(String title, int progess) {
        Intent intent = new Intent(this, DownloadActivty.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setChannelId("com.primedu.cn");
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .setContentTitle(title);
        if (progess > 0) {
            builder.setContentText(progess + "%");
            builder.setProgress(100, progess, false);
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
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(url);
                startForeground(1, getNotification("正在下载", 0));
                Toast.makeText(DownloadServer.this, "正在下载", Toast.LENGTH_SHORT).show();
            }

        }


    }

}
