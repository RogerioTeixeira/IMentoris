package com.texsoft.imentoris.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.texsoft.imentoris.CustomApplication;
import com.texsoft.imentoris.components.ApplicationComponent;

import butterknife.ButterKnife;

/**
 * Created by rogerio on 28/02/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements Contract.View {

    private ProgressDialog progressDialog;

    protected abstract int getLayoutResource();

    protected void addFragment(int containerViewId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }

    protected ApplicationComponent getApplicationComponent() {
        return (((CustomApplication) getApplication()).getApplicationComponent());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResource() != 0) {
            setContentView(getLayoutResource());
            ButterKnife.bind(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dismissDialog();
    }

    @Override
    public void showLoadingDialog(String message) {
        dismissDialog();
        progressDialog = ProgressDialog.show(this, "", message, true);
    }

    @Override
    public void showLoadingDialog(@StringRes int stringResource) {
        showLoadingDialog(getString(stringResource));
    }

    @Override
    public void dismissDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToastMessage(@StringRes int stringResource) {
        Toast.makeText(this, getString(stringResource), Toast.LENGTH_SHORT).show();
    }



}
