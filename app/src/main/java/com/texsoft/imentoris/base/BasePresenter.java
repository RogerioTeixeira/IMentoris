package com.texsoft.imentoris.base;

/**
 * Created by Rogerio Lavoro on 28/02/2017.
 */

public abstract class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.Presenter<T> {

    private T view;

    @Override
    public void onAttachView(T view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }
}
