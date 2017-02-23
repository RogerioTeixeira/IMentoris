package com.texsoft.imentoris.views.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.texsoft.imentoris.CustomApplication;
import com.texsoft.imentoris.R;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DaggerLoginComponent.builder()
                .applicationComponent(((CustomApplication) getApplication()).getAppComponent())
                .loginPresenterModule(new LoginPresenterModule(this))
                .build().inject(this);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void showDialogProgress() {

    }

    @Override
    public void hideDialogProgress() {

    }
}
