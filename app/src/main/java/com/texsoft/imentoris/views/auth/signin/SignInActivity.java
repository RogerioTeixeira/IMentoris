package com.texsoft.imentoris.views.auth.signin;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseActivity;
import com.texsoft.imentoris.components.ActivityComponent;

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
    protected void inject(ActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_in;
    }
}
