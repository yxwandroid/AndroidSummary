package com.xiaowu.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button viewById = (Button) findViewById(R.id.btn);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ss", Toast.LENGTH_SHORT).show();
            }
        });
        setSupportActionBar(toolbar);

      //  getSupportActionBar().setDisplayShowTitleEnabled(false);
      //  toolbar.setTitle("主标题");
      //  toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
       // toolbar.setSubtitle("副标题");
      //  toolbar.setLogo(R.mipmap.ic_launcher);
//        toolbar.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(MainActivity.this, "logo", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//        toolbar.setNavigationIcon(android.R.drawable.ic_input_delete);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "图标点击", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_edit:
//                Toast.makeText(this, "查找按钮", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.action_share:
//                Toast.makeText(this, "分享按钮", Toast.LENGTH_SHORT).show();
//                break;
//        }
//
//        return false;
//    }

}
