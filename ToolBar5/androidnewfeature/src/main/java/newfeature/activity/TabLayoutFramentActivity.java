package newfeature.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import newfeature.R;
import newfeature.adapter.MyFragmentPagerAdapter;

public class TabLayoutFramentActivity extends AppCompatActivity {

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    private MyFragmentPagerAdapter mAdapter;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    private String[] mTitle = new String[4];
    private String[] mData = new String[4];

    {
        for (int i = 0; i < 4; i++) {
            mTitle[i] = "title" + i;
            mData[i] = "data" + i;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_frament);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mTitle);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.tl);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }


}
