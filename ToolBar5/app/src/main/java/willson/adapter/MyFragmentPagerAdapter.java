package willson.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import willson.bean.TabTitle;
import willson.fragment.PageFragment;

/**
 * @描述 ${cursor};
 * @Author willson  {  http://xiaowutongxue.com   }
 * @创建日期 ${date} ${time}
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context context;


    private ArrayList<TabTitle> tabTitles;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context, ArrayList<TabTitle> tabTitles) {
        super(fm);
        this.context = context;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return tabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position).getTitles();
    }
}
