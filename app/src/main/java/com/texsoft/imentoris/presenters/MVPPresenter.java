package com.texsoft.imentoris.presenters;

import com.texsoft.imentoris.views.MVPView;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public interface MVPPresenter<T extends MVPView> {
    void onViewAttached(T view);

    void onViewDetached();
}
