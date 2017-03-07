package com.texsoft.imentoris.views.auth.signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.texsoft.imentoris.R;

public class SignUpActivity extends AppCompatActivity {

    private final String TAG_FRAGMENT_RETAIN = "FRAGGMENT_RETAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_RETAIN) == null) {
            Log.v("TestDagger", "Fragment null");
        } else {
            Log.v("TestDagger", "Fragment no null");
        }
    }
}
