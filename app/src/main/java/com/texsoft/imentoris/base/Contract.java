package com.texsoft.imentoris.base;

import android.support.annotation.StringRes;

/**
 * Created by Rogerio Lavoro on 28/02/2017.
 */

public interface Contract {
    interface Presenter {
        void onStart();

        void onStop();
    }
    interface View {
        void showLoadingDialog(String message);

        void showLoadingDialog(@StringRes int stringResource);

        void dismissDialog();

        void showToastMessage(String message);

        void showToastMessage(@StringRes int stringResource);
    }
}
