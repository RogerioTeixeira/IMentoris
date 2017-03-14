package com.texsoft.imentoris.events;

import android.support.annotation.StringRes;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class EventProgressDialog {
    private int messageRes;
    private String message;

    public EventProgressDialog(@StringRes int messageRes) {
        this.messageRes = messageRes;
    }

    public EventProgressDialog(String message) {
        this.message = message;
    }

    public int getMessageRes() {
        return messageRes;
    }

    public String getMessage() {
        return message;
    }
}
