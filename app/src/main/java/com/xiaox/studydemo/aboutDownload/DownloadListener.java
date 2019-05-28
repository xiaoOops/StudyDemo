package com.xiaox.studydemo.aboutDownload;

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
public interface DownloadListener {

    void onProgress(int progess);

    void onPause();

    void onCancel();

    void onFail();

    void onSuccess();


}
