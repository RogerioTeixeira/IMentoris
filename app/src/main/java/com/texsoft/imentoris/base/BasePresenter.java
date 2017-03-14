package com.texsoft.imentoris.base;

/**
 * Created by Rogerio Lavoro on 28/02/2017.
 */

public abstract class BasePresenter implements Contract.Presenter {

    @Override
    public void onStart() {
        //  EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {

        //EventBus.getDefault().unregister(this);
    }
}
