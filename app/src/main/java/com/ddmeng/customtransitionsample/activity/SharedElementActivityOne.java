package com.ddmeng.customtransitionsample.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

import com.ddmeng.customtransitionsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedElementActivityOne extends AppCompatActivity {

    @BindView(R.id.shared_image_view)
    ImageView mSharedImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // requestFeature() must be called before adding content, before super.onCreate() and setContentView()
        if (Build.VERSION.SDK_INT > 20) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_activity_one);


        ButterKnife.bind(this);
    }

    @OnClick(R.id.go_to_next_button)
    void goToNextActivity() {
        Intent intent = new Intent(SharedElementActivityOne.this, SharedElementActivityTwo.class);
        if (Build.VERSION.SDK_INT > 20) {
            // create the transition animation - the images in the layouts
            // of both activities are defined with android:transitionName="robot"
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(this, mSharedImageView, "robot");
            // start the new activity
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
