package com.texsoft.imentoris.base;

/**
 * Created by Rogerio Lavoro on 28/02/2017.
 */

public interface BaseContract {
    interface Presenter<T extends View> {
        void onAttachView(T view);

        void onDetachView();
    }

    interface View {
        void showDialogProgress();

        void hideDialogProgress();
    }
}
