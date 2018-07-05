package willson.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fm.mow.com.toolbar.R;



/**
 *@describe: ""
 *@author : willson { http://xiaowutongxue.com}
 *@Data :  "2016/11/24"  "下午6:02"
 **/

public class FragmentOne extends Fragment {


    private static final String TAG = FragmentOne.class.getName();
    private  static  int i =0;
    public FragmentOne() {

        Log.d(TAG, "FragmentOne: "+i);
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "FragmentOne: "+i);
        return inflater.inflate(R.layout.layout_one,container,false);
    }

}
