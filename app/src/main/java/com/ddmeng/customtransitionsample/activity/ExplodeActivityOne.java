package com.ddmeng.customtransitionsample.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.ddmeng.customtransitionsample.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExplodeActivityOne extends Activity {
    //if you want to use the style in xml, you should not extends from AppCompatActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explode_activity_one);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.go_to_next_button)
    void goToNextActivity() {
        Intent intent = new Intent(ExplodeActivityOne.this, ExplodeActivityTwo.class);
        if (Build.VERSION.SDK_INT > 20) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            // start the new activity
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
