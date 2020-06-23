package com.wilson.serviceview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.PermissionListener;
import com.yhao.floatwindow.Screen;
import com.yhao.floatwindow.ViewStateListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ShortCutPhraseService.class);
//                intent.putExtra("args","start");
//                startService(intent);


           initView2();
//                startActivity(new Intent(MainActivity.this,Main3Activity.class));
            }

        });
        findViewById(R.id.end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ShortCutPhraseService.class);
//                intent.putExtra("args","end");
////                startService(intent);
//                stopService(intent);
//

                FloatWindow.destroy("110");
            }
        });

        TextView viewById = findViewById(R.id.text);
        viewById.setText("");
        Intent intent = new Intent(this, KeepLifeService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
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
                .setTag("110")
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
        FloatWindow.get("110").show();
    }
//    public List<Reply> listGroupTree(ReplyGroup param) {
//
//        if (OwnerTypeEnum.部门 == param.ownerType) {
//            Account account = accountService.getAccountById(param.currentAccountId);
//            param.departmentId = account.getDepartmentId();
//        }
//
//
//        // 快捷回复
//        Map<String, Reply> mapInfos = new HashMap<>();
//        List<ReplyGroup> groups = readonlySqlSession.selectList("listAllGroups", param);
//        if (groups == null || groups.size() == 0) {
//            return new ArrayList<>();
//        }
//        groups.forEach(group -> {
//            if (group != null && StringUtils.isNotBlank(group.id)) {
//                mapInfos.put(group.id, group);
//            }
//        });
//        List<String> toRemoveKeys = new ArrayList<>();
//
//        mapInfos.forEach((mapInfoKey, mapInfo) -> {
//            if (StringUtils.isNotBlank(mapInfo.parentId)) {
//                ReplyGroup parentInfo = mapInfos.get(mapInfo.parentId);
//                if (parentInfo != null) {
//                    if (parentInfo.children == null) {
//                        parentInfo.children = new ArrayList<>();
//                    }
//                    parentInfo.children.add(mapInfo);
//                    toRemoveKeys.add(mapInfoKey);
//                }
//            }
//        });
//        toRemoveKeys.forEach(mapInfos::remove);
//        List<Reply> results = new ArrayList<>();
//        mapInfos.forEach((key, info) -> results.add(info));
//        return results;
//    }
//
//



    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };


    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
