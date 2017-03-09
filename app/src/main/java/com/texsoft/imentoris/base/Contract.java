package com.texsoft.imentoris.base;

/**
 * Created by Rogerio Lavoro on 28/02/2017.
 */

public interface Contract {
    interface Presenter<T extends View> {
        void onAttachView(T view);

        void onDetachView();
    }

    interface View {
        void showLoadingDialog(String message);

        void dismissDialog();

        void showToastMessage(String message);
    }
}
