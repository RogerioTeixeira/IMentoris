package com.texsoft.imentoris.views.login;

import com.texsoft.imentoris.presenters.MVPPresenter;
import com.texsoft.imentoris.views.MVPView;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public interface LoginContract {
    interface View extends MVPView {
        void Onsuccess();
    }

    interface Presenter extends MVPPresenter<View> {
        void loginWithPassword(String user, String password);

        void Onsuccess();
    }
}
