package willson.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import fm.mow.com.toolbar.R;


/**
 * @author : willson { http://xiaowutongxue.com}
 * @describe: ""
 * @Data :  "2016/11/23"  "下午5:18"
 **/
public class CollapsingToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.ctl);
        ctl.setTitle("Cool UI");
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.banner);
        Palette.generateAsync(bmp, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getDarkMutedSwatch();
                ctl.setContentScrimColor(swatch.getRgb());
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
