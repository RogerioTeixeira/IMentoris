package com.texsoft.imentoris.views.login;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public interface LoginContract {
    interface View extends BaseView {
        void onSuccess();
    }

    interface Presenter extends BasePresenter<View> {
        void signInWithPassword(String email, String password);
    }

}
