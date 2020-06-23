package com.wilson.serviceview;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.PermissionListener;
import com.yhao.floatwindow.Screen;
import com.yhao.floatwindow.ViewStateListener;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
//        initView2();

    }


    /**
     * FloatWindow使用FloatWindow库展示悬浮框；可拖拽
     */
    private void initView2() {
        final View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_win, null);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
                //显示方式声明Intent，直接启动SecondActivity
//                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
//                startActivity(intent);

//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.setData(Uri.parse( "package:"+"com.example.administrator.xuanfudemo"));  //应用的包名，可直接跳转到这个应用的悬浮窗设置；
                getApplicationContext().startActivity(intent);

            }
        });
        FloatWindow
                .with(getApplicationContext())
                .setView(inflate)
//                .setWidth(200)                               //设置控件宽高
                .setWidth(150)                               //设置控件宽高
                .setHeight(150)
//                .setHeight(Screen.height, 0.2f)
                .setX(100)                                   //设置控件初始位置
                .setY(Screen.height, 0.3f)
                .setDesktopShow(true)                        //桌面显示
                .setViewStateListener(new ViewStateListener() {
                    @Override
                    public void onPositionUpdate(int i, int i1) {
                        Toast.makeText(getApplicationContext(),"onPositionUpdate",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onShow() {
                        Toast.makeText(getApplicationContext(),"onShow",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onHide() {
                        Toast.makeText(getApplicationContext(),"onHide",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onDismiss() {
                        Toast.makeText(getApplicationContext(),"onDismiss",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onMoveAnimStart() {
                        Toast.makeText(getApplicationContext(),"onMoveAnimStart",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onMoveAnimEnd() {
                        Toast.makeText(getApplicationContext(),"onMoveAnimEnd",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onBackToDesktop() {
                        Toast.makeText(getApplicationContext(),"onBackToDesktop",Toast.LENGTH_LONG).show();
                    }
                })
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(),"onSuccess",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFail() {
                        Toast.makeText(getApplicationContext(),"onFail",Toast.LENGTH_LONG).show();
                    }
                })
                .build();
        FloatWindow.get().show();
    }
}
