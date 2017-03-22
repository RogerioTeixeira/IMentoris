package com.texsoft.imentoris.base;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.texsoft.imentoris.CustomApplication;
import com.texsoft.imentoris.components.ApplicationComponent;
import com.texsoft.imentoris.components.DaggerFragmentComponent;
import com.texsoft.imentoris.components.FragmentComponent;
import com.texsoft.imentoris.events.ProgressDialogEvent;
import com.texsoft.imentoris.events.ShowToastEvent;
import com.texsoft.imentoris.modules.PresenterModule;
import com.texsoft.imentoris.util.Validator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements Contract.View {

    private ProgressDialog progressDialog;

    public BaseFragment() {
        // Required empty public constructor
    }

    protected abstract int getLayoutResource();

    protected abstract void inject(FragmentComponent component);

    @Override
    public void showLoadingDialog(String message) {
        dismissDialog();
        progressDialog = ProgressDialog.show(getContext(), "", message, true);
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
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToastMessage(@StringRes int stringResource) {
        Toast.makeText(getContext(), getString(stringResource), Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnEvent(ProgressDialogEvent e) {
        if (!e.isEventFor(this.getClass()))
            return;

        switch (e.dialogState) {
            case HIDE:
                dismissDialog();
                break;
            case SHOW:
                if (e.getMessageRes() != 0) {
                    showLoadingDialog(e.getMessageRes());
                } else if (!Validator.isEmpty(e.getMessage())) {
                    showLoadingDialog(e.getMessage());
                } else {
                    showLoadingDialog("");
                }
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnEvent(ShowToastEvent e) {
        if (!e.isEventFor(this.getClass()))
            return;

        if (e.getMessageRes() != 0) {
            showToastMessage(e.getMessageRes());
        } else if (!Validator.isEmpty(e.getMessage())) {
            showToastMessage(e.getMessage());
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, view);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }

    public void setTitleToolBar(@StringRes int res) {
        if (getActivity() instanceof AppCompatActivity) {
            String title = getString(res);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        inject(getFragmentComponent());
        Log.v("AdaperPager", "Fragment create:" + this.getClass().getName());
    }

    protected void hideSoftInput() {
        Log.v("Hide", "hide keyboard");
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .presenterModule(new PresenterModule())
                .build();
    }

    private ApplicationComponent getApplicationComponent() {
        return ((CustomApplication) getActivity().getApplication()).getApplicationComponent();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("AdaperPager", "Fragment onStart:" + this.getClass().getName());
        EventBus.getDefault().register(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v("AdaperPager", "Fragment onAttach:" + this.getClass().getName());
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        Log.v("AdaperPager", "Fragment onStop:" + this.getClass().getName());
        dismissDialog();
        super.onStop();
    }


}
