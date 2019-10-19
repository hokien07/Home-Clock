package hokien07.developer.clock.views.activitys;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextClock;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Locale;

import hokien07.developer.clock.R;
import hokien07.developer.clock.adapters.SlidingImage_Adapter;
import hokien07.developer.clock.presenters.ClockInterface;
import hokien07.developer.clock.presenters.ClockPresenter;

public class ClockActivity extends BaseActivity implements ClockInterface.View {


    private TextClock clock, date;
    private ArrayList<Integer> Images;
    private ClockPresenter clockPresenter;
    private ViewPager pager;
    private SlidingImage_Adapter adapter;
    private static final int TIME_CHANGE_IMAGE = 10000;
    private Handler handler;
    private Runnable runnable;


    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        clockPresenter = new ClockPresenter(this);

        Images = new ArrayList<>();
        Images.add(R.drawable.hinh_1);
        Images.add(R.drawable.hinh_2);
        Images.add(R.drawable.hinh_3);
        Images.add(R.drawable.hinh_4);
        Images.add(R.drawable.hinh_5);
        Images.add(R.drawable.hinh_6);
        Images.add(R.drawable.hinh_7);

        pager = findViewById(R.id.viewPager);
        adapter = new SlidingImage_Adapter(this, Images);
        pager.setAdapter(adapter);
        clock = findViewById(R.id.clock);
        date = findViewById(R.id.date);
        AssetManager am = getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "digital.ttf"));

        Typeface typefaceDate = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "digital_italic.ttf"));
        clock.setTypeface(typeface);
        date.setTypeface(typefaceDate);



        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                clockPresenter.handlerChangeImage();
                handler.postDelayed(runnable, TIME_CHANGE_IMAGE);
            }
        }, TIME_CHANGE_IMAGE);
    }

    @Override
    public void onChangeImage(int position) {
        pager.setCurrentItem(position, true);
    }


}
