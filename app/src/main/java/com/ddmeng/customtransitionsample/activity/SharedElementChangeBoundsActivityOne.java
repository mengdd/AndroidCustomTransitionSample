package com.ddmeng.customtransitionsample.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeTransform;
import android.view.Window;
import android.widget.ImageView;

import com.ddmeng.customtransitionsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedElementChangeBoundsActivityOne extends AppCompatActivity {

    @BindView(R.id.shared_image_view)
    ImageView mSharedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT > 20) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

            // you can try different transitions here
            getWindow().setSharedElementExitTransition(new ChangeTransform());
//            getWindow().setSharedElementEnterTransition(new ChangeBounds());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_change_bounds_activity_one);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.go_to_next_button)
    void goToNextActivity() {
        Intent intent = new Intent(SharedElementChangeBoundsActivityOne.this, SharedElementChangeBoundsActivityTwo.class);
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
