package willson.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import fm.mow.com.toolbar.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private TextView coll;
    private TextView appbar;
    private TextView tab;
    private TextView toobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // toolbar.inflateMenu(R.menu.zhihu_toolbar_menu);
        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);

        toolbar.setTitle(R.string.home_page);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.simple_navigation_drawer);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);


        coll = (TextView) findViewById(R.id.coll);
        appbar = (TextView) findViewById(R.id.appbar);
        tab = (TextView) findViewById(R.id.tab);
        toobar = (TextView) findViewById(R.id.toobar);
        appbar.setOnClickListener(this);
        coll.setOnClickListener(this);
        tab.setOnClickListener(this);
        toobar.setOnClickListener(this);

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coll:
                this.startActivity(new Intent(this,CollapsingToolbarActivity.class));
                break;
            case R.id.appbar:
                this.startActivity(new Intent(this,AppBarTabLayoutActivity.class));
                break;
            case R.id.tab:
                this.startActivity(new Intent(this,TabLayoutActivity.class));
                break;
            case R.id.toobar:
                this.startActivity(new Intent(this,ToolbarActivity.class));
                break;
        }

    }


}
