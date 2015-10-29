package com.ddmeng.customtransitionsample;

import android.app.Activity;

public class Sample {
    private CharSequence title;
    private Class<? extends Activity> activityClass;

    public Sample(CharSequence title, Class<? extends Activity> activityClass) {
        this.activityClass = activityClass;
        this.title = title;
    }

    public CharSequence getTitle() {
        return title;
    }

    public Class<? extends Activity> getActivityClass() {
        return activityClass;
    }

    @Override
    public String toString() {
        return title.toString();
    }
}
