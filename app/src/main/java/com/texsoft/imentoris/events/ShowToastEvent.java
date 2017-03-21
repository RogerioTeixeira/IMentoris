package com.texsoft.imentoris.events;

import android.support.annotation.StringRes;

import com.texsoft.imentoris.base.BaseEvent;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class ShowToastEvent extends BaseEvent {

    private int messageRes;
    private String message;

    public ShowToastEvent(@StringRes int messageRes) {

        this.messageRes = messageRes;

    }

    public ShowToastEvent(String message) {

        this.message = message;
    }

    public int getMessageRes() {
        return messageRes;
    }

    public String getMessage() {
        return message;
    }


}
