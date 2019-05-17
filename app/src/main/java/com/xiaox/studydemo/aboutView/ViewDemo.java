package com.xiaox.studydemo.aboutView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.xiaox.studydemo.R;

/**
 * @version V1.0
 * @Title: Loan
 * @Description: view、window 的理解
 * @date 2019/5/17
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class ViewDemo extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = new Button(this, null);
        button.setText("hahaha");
        WindowManager windowManager = getWindowManager();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        //实际上这样是创建了一个 window ！！！
        windowManager.addView(button, layoutParams);

    }
}
