package com.texsoft.imentoris.base;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.texsoft.imentoris.CustomApplication;
import com.texsoft.imentoris.components.ApplicationComponent;
import com.texsoft.imentoris.components.DaggerFragmentComponent;
import com.texsoft.imentoris.components.FragmentComponent;
import com.texsoft.imentoris.modules.PresenterModule;

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        inject(getFragmentComponent());
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

}
