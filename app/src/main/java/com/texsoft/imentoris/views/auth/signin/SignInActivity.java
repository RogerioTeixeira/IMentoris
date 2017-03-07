package com.texsoft.imentoris.views.auth.signin;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.texsoft.imentoris.ApplicationComponent;
import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseActivity;
import com.texsoft.imentoris.views.auth.signup.SignUpActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SignInActivity extends BaseActivity<SignInContract.Presenter, SignInComponent> implements SignInContract.View {

    @BindView(R.id.btn_login_email)
    Button btnProva;
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.activity_login)
    RelativeLayout activityLogin;
    @BindView(R.id.text_create_account)
    TextView textCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/lobster.otf");
        titleTextview.setTypeface(face);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected SignInComponent createComponent(ApplicationComponent component) {
        return DaggerSignInComponent.builder()
                .applicationComponent(component)
                .signInPresenterModule(new SignInPresenterModule())
                .build();
    }

    @Override
    protected void injectComponent(SignInComponent component) {
        component.inject(this);
    }

    @Override
    public void onSuccess() {
        Log.v("TestDagger", "Chiamata OnSuccess");
    }

    @OnClick({R.id.btn_login_email, R.id.text_create_account})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_email:
                break;
            case R.id.text_create_account:
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }
}
