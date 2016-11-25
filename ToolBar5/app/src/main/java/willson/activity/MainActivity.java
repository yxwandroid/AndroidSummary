package willson.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import fm.mow.com.toolbar.R;
import willson.fragment.FragmentOne;
import willson.fragment.FragmentThree;
import willson.fragment.FragmentTwo;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置ToolBar
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);

        //设置抽屉DrawerLayout
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.simple_navigation_drawer);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.open, R.string.close);
        mDrawerToggle.syncState();//初始化状态
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //设置导航栏NavigationView的点击事件
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_one:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new FragmentOne()).commit();
                        mToolbar.setTitle("我的动态");
                        break;
                    case R.id.item_two:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new FragmentTwo()).commit();
                        mToolbar.setTitle("我的留言");
                        break;
                    case R.id.item_three:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new FragmentThree()).commit();
                        mToolbar.setTitle("附近的人");
                        break;
                }
                menuItem.setChecked(true);//点击了把它设为选中状态
                mDrawerLayout.closeDrawers();//关闭抽屉
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
//    private Toolbar toolbar;
//    private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mActionBarDrawerToggle;
//    private TextView coll;
//    private TextView appbar;
//    private TextView tab;
//    private TextView toobar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        // toolbar.inflateMenu(R.menu.zhihu_toolbar_menu);
//        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
//
//        toolbar.setTitle(R.string.home_page);
//        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
//
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.simple_navigation_drawer);
//        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
//        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
//
//
//        coll = (TextView) findViewById(R.id.coll);
//        appbar = (TextView) findViewById(R.id.appbar);
//        tab = (TextView) findViewById(R.id.tab);
//        toobar = (TextView) findViewById(R.id.toobar);
//        appbar.setOnClickListener(this);
//        coll.setOnClickListener(this);
//        tab.setOnClickListener(this);
//        toobar.setOnClickListener(this);
//
//    }
//
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mActionBarDrawerToggle.syncState();
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.coll:
//                this.startActivity(new Intent(this,CollapsingToolbarActivity.class));
//                break;
//            case R.id.appbar:
//                this.startActivity(new Intent(this,AppBarTabLayoutActivity.class));
//                break;
//            case R.id.tab:
//                this.startActivity(new Intent(this,TabLayoutActivity.class));
//                break;
//            case R.id.toobar:
//                this.startActivity(new Intent(this,ToolbarActivity.class));
//                break;
//        }
//
//    }


}
