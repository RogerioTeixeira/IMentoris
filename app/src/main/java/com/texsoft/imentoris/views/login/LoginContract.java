package com.texsoft.imentoris.views.login;

import com.texsoft.imentoris.BaseView;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public interface LoginContract {
    interface View extends BaseView {
        void onSuccess();
    }

    interface Presenter {
        void signInWithPassword(String email, String password);
    }

}
