package com.texsoft.imentoris.base;

/**
 * Created by Rogerio Lavoro on 28/02/2017.
 */

public abstract class BasePresenter<T extends Contract.View> implements Contract.Presenter<T> {

    protected T view;

    @Override
    public void onAttachView(T view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }
}
