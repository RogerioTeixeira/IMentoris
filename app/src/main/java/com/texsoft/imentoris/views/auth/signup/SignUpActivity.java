package com.texsoft.imentoris.views.auth.signup;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseActivity;

public class SignUpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Fragment fragment = new SignUpFragment();
            addFragment(R.id.fragmentContainer, fragment);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_up;
    }

}
