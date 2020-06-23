package willson.adapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import willson.fragment.PageFragment;

/**
 * @描述 ${cursor};
 * @Author willson  {  http://xiaowutongxue.com   }
 * @创建日期 ${date} ${time}
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    public final int COUNT = 5;
    private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
