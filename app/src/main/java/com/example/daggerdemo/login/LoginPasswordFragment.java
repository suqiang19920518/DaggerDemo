package com.example.daggerdemo.login;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daggerdemo.R;

import javax.inject.Inject;

public class LoginPasswordFragment extends Fragment {
    private static final String TAG = LoginPasswordFragment.class.getSimpleName();

    @Inject
    LoginViewModel loginViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //执行注入动作
        ((LoginActivity) getActivity()).loginComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "LoginViewModel:" + loginViewModel.toString() + "==========UserRepository:" + loginViewModel.getUserRepository());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_password, container, false);
    }
}