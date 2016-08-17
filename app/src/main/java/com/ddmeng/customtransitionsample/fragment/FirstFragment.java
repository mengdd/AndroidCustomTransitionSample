package com.ddmeng.customtransitionsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddmeng.customtransitionsample.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstFragment extends Fragment {

    public interface Callback {
        void openSecondFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.btn_open_second)
    void openSecondFragment() {
        ((Callback) getActivity()).openSecondFragment();
    }
}
