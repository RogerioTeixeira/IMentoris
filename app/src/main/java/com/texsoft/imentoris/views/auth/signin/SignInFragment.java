package com.texsoft.imentoris.views.auth.signin;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseFragment;
import com.texsoft.imentoris.components.FragmentComponent;
import com.texsoft.imentoris.views.auth.signup.SignUpActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends BaseFragment {

    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.email_input_edit)
    TextInputEditText emailInputEdit;
    @BindView(R.id.email_input_layout)
    TextInputLayout emailInputLayout;
    @BindView(R.id.password_input_edit)
    TextInputEditText passwordInputEdit;
    @BindView(R.id.password_input_layout)
    TextInputLayout passwordInputLayout;
    @BindView(R.id.text_recover_password)
    TextView textRecoverPassword;
    @BindView(R.id.btn_login_email)
    Button btnLoginEmail;
    @BindView(R.id.btn_google)
    Button btnGoogle;
    @BindView(R.id.btn_facebook)
    Button btnFacebook;
    @BindView(R.id.text_create_account)
    TextView textCreateAccount;

    @Inject
    SignInContract.Presenter presenter;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/lobster.otf");
        titleTextview.setTypeface(face);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_signin;
    }

    @Override
    protected void inject(FragmentComponent component) {
        component.inject(this);
    }

    @OnClick({R.id.text_recover_password, R.id.btn_login_email, R.id.btn_google, R.id.btn_facebook, R.id.text_create_account})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_recover_password:
                break;
            case R.id.btn_login_email:
                presenter.signInWithPassword("Rogerio", "xrte1982", getActivity());
                break;
            case R.id.btn_google:
                break;
            case R.id.btn_facebook:
                break;
            case R.id.text_create_account:
                SignUpActivity.startActivity(getActivity());
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
        Log.v("TestDagger", "Fragment onStart");
    }

    @Override
    public void onStop() {
        presenter.onStop();
        super.onStop();
        Log.v("TestDagger", "Fragment onStop");
    }
}
