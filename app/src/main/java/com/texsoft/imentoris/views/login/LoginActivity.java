package com.texsoft.imentoris.views.login;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.texsoft.imentoris.ApplicationComponent;
import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.btn_login_email)
    Button btnProva;
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.activity_login)
    RelativeLayout activityLogin;

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
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/lobster.otf");
        titleTextview.setTypeface(face);
    }

    @Override
    public void onSuccess() {
        Log.v("TestDagger", "Chiamata OnSuccess");
    }

    @OnClick(R.id.btn_login_email)
    public void onClick() {
        presenter.signInWithPassword("rogerio", "teixeira");
    }
}
