package com.texsoft.imentoris.views.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.texsoft.imentoris.ApplicationComponent;
import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.btn_prova)
    Button btnProva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void injectComponent(ApplicationComponent component) {
        DaggerLoginComponent.builder()
                .applicationComponent(component)
                .loginPresenterModule(new LoginPresenterModule())
                .build().inject(this);
    }

    @Override
    public void onSuccess() {
        Log.v("TestDagger", "Chiamata OnSuccess");
    }

    @OnClick(R.id.btn_prova)
    public void onClick() {
        presenter.signInWithPassword("rogerio", "teixeira");
    }
}
