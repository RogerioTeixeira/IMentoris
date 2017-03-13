package com.texsoft.imentoris.views.auth.signin;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseActivity;

public class SignInActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Fragment fragment = new SignInFragment();
            addFragment(R.id.fragmentContainer, fragment);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_in;
    }
}
