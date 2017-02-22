package com.texsoft.imentoris.presenters;

import com.texsoft.imentoris.views.MVPView;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public class MVPPresenterImpl<T extends MVPView> implements MVPPresenter<T> {
    @Override
    public void onViewAttached(T view) {

    }

    @Override
    public void onViewDetached() {

    }
}
