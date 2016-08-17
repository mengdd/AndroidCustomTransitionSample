package com.ddmeng.customtransitionsample.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.widget.ImageView;

import com.ddmeng.customtransitionsample.R;

public class FragmentContainerActivity extends AppCompatActivity implements FirstFragment.Callback {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ImageView sharedImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container_activity);

        setUpFragmentTransition();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, firstFragment, FirstFragment.class.getSimpleName()).commit();
    }

    private void setUpFragmentTransition() {
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition changeTransform = TransitionInflater.from(this).inflateTransition(R.transition.change_image_transform);
            Transition explodeTransform = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);

            firstFragment.setSharedElementReturnTransition(changeTransform);
            firstFragment.setExitTransition(explodeTransform);

            secondFragment.setSharedElementEnterTransition(changeTransform);
            secondFragment.setEnterTransition(explodeTransform);
        }
    }

    @Override
    public void openSecondFragment() {
        sharedImage = (ImageView) findViewById(R.id.image_in_first_fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.container, secondFragment, SecondFragment.class.getSimpleName())
                .addToBackStack(SecondFragment.class.getSimpleName())
                .addSharedElement(sharedImage, getString(R.string.fragment_transition_shared_element_transition_name))
                .commit();
    }
}
