package com.ddmeng.customtransitionsample.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.ddmeng.customtransitionsample.R;

public class SharedElementActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // requestFeature() must be called before adding content, before super.onCreate() and setContentView()
        if (Build.VERSION.SDK_INT > 20) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_activity_two);
    }
}
