package com.texsoft.imentoris.views.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.texsoft.imentoris.CustomApplication;
import com.texsoft.imentoris.R;
import com.texsoft.imentoris.modules.LoginActivityModule;
import com.texsoft.imentoris.presenters.LoginPresenter;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        CustomApplication.getCustomApplication(this)
                .getAppComponent()
                .plus(new LoginActivityModule(this))
                .inject(this);
        if (presenter == null) {
            Log.v("LoginPresenter", "KO");
        } else {
            Log.v("LoginPresenter", "OK");
            presenter.displayAuth();
        }
    }
}
