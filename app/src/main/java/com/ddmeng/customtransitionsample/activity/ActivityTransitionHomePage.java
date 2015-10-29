package com.ddmeng.customtransitionsample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ddmeng.customtransitionsample.R;
import com.ddmeng.customtransitionsample.Sample;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ActivityTransitionHomePage extends AppCompatActivity {

    @Bind(R.id.activity_transition_samples_list)
    ListView mListView;

    private static Sample[] mSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_home_page);

        ButterKnife.bind(this);

        mSamples = new Sample[]{
                new Sample(getResources().getString(R.string.activity_transition_shared_elements), SharedElementActivityOne.class),
        };

        mListView.setAdapter(new ArrayAdapter<Sample>(this, android.R.layout.simple_list_item_1, android.R.id.text1, mSamples));
    }

    @OnItemClick(R.id.activity_transition_samples_list)
    void onSampleListClick(AdapterView<?> parent, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(ActivityTransitionHomePage.this, mSamples[position].getActivityClass()));
    }
}
