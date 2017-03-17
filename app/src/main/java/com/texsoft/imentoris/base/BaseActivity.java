package com.texsoft.imentoris.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.texsoft.imentoris.CustomApplication;
import com.texsoft.imentoris.components.ActivityComponent;
import com.texsoft.imentoris.components.ApplicationComponent;
import com.texsoft.imentoris.components.DaggerActivityComponent;
import com.texsoft.imentoris.events.EventProgressDialog;
import com.texsoft.imentoris.modules.ActivityModule;
import com.texsoft.imentoris.modules.PresenterModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

/**
 * Created by rogerio on 28/02/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements Contract.View {

    private ProgressDialog progressDialog;

    protected abstract int getLayoutResource();

    protected void inject(ActivityComponent component) {

    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }

    protected ApplicationComponent getApplicationComponent() {
        return (((CustomApplication) getApplication()).getApplicationComponent());
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .presenterModule(new PresenterModule())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResource() != 0) {
            setContentView(getLayoutResource());
            ButterKnife.bind(this);
        }
        inject(getActivityComponent());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        dismissDialog();
        super.onStop();
    }

    @Override
    public void showLoadingDialog(String message) {
        dismissDialog();
        progressDialog = ProgressDialog.show(this, "", message, true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnEvent(EventProgressDialog e) {

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
