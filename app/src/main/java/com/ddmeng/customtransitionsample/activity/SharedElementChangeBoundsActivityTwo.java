package com.ddmeng.customtransitionsample.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.view.Window;

import com.ddmeng.customtransitionsample.R;

public class SharedElementChangeBoundsActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // requestFeature() must be called before adding content, before super.onCreate() and setContentView()
        if (Build.VERSION.SDK_INT > 20) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            // you can try different transitions here
            getWindow().setSharedElementEnterTransition(new ChangeBounds());
//            getWindow().setSharedElementExitTransition(new ChangeBounds());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shard_element_change_bounds_activity_two);
    }
}
