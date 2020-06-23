

package com.wilson.serviceview;

import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.PermissionListener;
import com.yhao.floatwindow.Screen;
import com.yhao.floatwindow.ViewStateListener;

public class ShortCutPhraseService extends Service {
    private final String TAG = "ShortCutPhraseService";
    private String args;
    public ShortCutPhraseService() {
        Log.i(TAG, "-------ShortCutPhraseService------- ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "------onBind-------");
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "------onCreate-------");
        initView2();

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        args = intent.getStringExtra("args");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * FloatWindow使用FloatWindow库展示悬浮框；可拖拽
     */
    private void initView2() {
        final View inflate = LayoutInflater.from(this).inflate(R.layout.view_win, null);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
            }
        });
        FloatWindow
                .with(getApplicationContext())
                .setView(inflate)
//                .setWidth(200)                               //设置控件宽高
                .setWidth(100)                               //设置控件宽高
                .setHeight(100)
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


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "------onDestroy-------");
        FloatWindow.destroy();
    }
}
