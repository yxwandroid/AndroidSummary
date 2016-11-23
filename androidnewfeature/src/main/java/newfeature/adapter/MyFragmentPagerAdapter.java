package newfeature.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import newfeature.activity.TabLayoutFramentActivity;
import newfeature.frament.MyFragment1;
import newfeature.frament.MyFragment2;
import newfeature.frament.MyFragment3;
import newfeature.frament.MyFragment4;

/**
 * Created by willson on 2015/8/31 0031.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private MyFragment1 myFragment1 = null;
    private MyFragment2 myFragment2 = null;
    private MyFragment3 myFragment3 = null;
    private MyFragment4 myFragment4 = null;
    String[] mTitle;

    public MyFragmentPagerAdapter(FragmentManager fm ,String[] mTitle ) {
        super(fm);
        this.mTitle=mTitle;
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
        myFragment4 = new MyFragment4();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case TabLayoutFramentActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case TabLayoutFramentActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case TabLayoutFramentActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case TabLayoutFramentActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }


}

