package com.texsoft.imentoris.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.texsoft.imentoris.ApplicationComponent;

public abstract class BaseFragment extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String f = this.getComponent();
        return null;
    }


    protected <C extends ApplicationComponent> C getComponent() {
        return ((HasComponent<C>) getActivity()).getComponent();
    }

}
