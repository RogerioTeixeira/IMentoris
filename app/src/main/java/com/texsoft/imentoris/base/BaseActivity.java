package com.texsoft.imentoris.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import com.texsoft.imentoris.ApplicationComponent;
import com.texsoft.imentoris.CustomApplication;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by rogerio on 28/02/2017.
 */

public abstract class BaseActivity<T extends Contract.Presenter> extends AppCompatActivity implements Contract.View {
    @Inject
    protected T presenter;

    private ProgressDialog progressDialog;


    protected abstract int getLayoutResource();

    protected abstract void injectComponent(ApplicationComponent component);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResource() != 0) {
            setContentView(getLayoutResource());
            ButterKnife.bind(this);
        }
        injectComponent(((CustomApplication) getApplication()).getAppComponent());

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDetachView();
        dismissDialog();
    }

    @Override
    public void showLoadingDialog(String message) {
        dismissDialog();
        progressDialog = ProgressDialog.show(this, "", message, true);
    }

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



}
