package com.ddmeng.customtransitionsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ddmeng.customtransitionsample.R;

public class FragmentContainerActivity extends AppCompatActivity implements FirstFragment.Callback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container_activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new FirstFragment(), FirstFragment.class.getSimpleName()).commit();
    }

    @Override
    public void openSecondFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.container, new SecondFragment(), SecondFragment.class.getSimpleName())
                .addToBackStack(SecondFragment.class.getSimpleName())
                .commit();
    }
}
