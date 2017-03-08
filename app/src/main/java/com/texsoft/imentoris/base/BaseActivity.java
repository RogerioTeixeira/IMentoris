package com.texsoft.imentoris.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.texsoft.imentoris.ApplicationComponent;
import com.texsoft.imentoris.CustomApplication;
import com.texsoft.imentoris.util.RetainFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by rogerio on 28/02/2017.
 */

public abstract class BaseActivity<T extends Contract.Presenter, V extends ApplicationComponent> extends AppCompatActivity implements Contract.View {
    private final String TAG_FRAGMENT_RETAIN = "FRAGGMENT_RETAIN";

    @Inject
    protected T presenter;


    protected V component;
    private ProgressDialog progressDialog;
    private RetainFragment<V> retainFragment;

    protected abstract int getLayoutResource();

    protected abstract V createComponent(ApplicationComponent component);

    protected abstract void injectComponent(V component);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResource() != 0) {
            setContentView(getLayoutResource());
            ButterKnife.bind(this);
        }
        if (savedInstanceState == null) {
            retainFragment = new RetainFragment<>();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(retainFragment, TAG_FRAGMENT_RETAIN)
                    .commit();
            component = createComponent(((CustomApplication) getApplication()).getAppComponent());
            retainFragment.setData(component);
            Log.v("TestDagger", "Fragment base null");
        } else {
            retainFragment = (RetainFragment<V>) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_RETAIN);
            component = retainFragment.getData();
            Log.v("TestDagger", "Fragment base non null:" + component.toString());
        }
        injectComponent(component);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            Log.v("TestDagger", "Finish fragment");
            getSupportFragmentManager().beginTransaction().remove(retainFragment).commit();
        }
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
