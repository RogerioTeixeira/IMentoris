package com.texsoft.imentoris.events;

import android.support.annotation.StringRes;

import com.texsoft.imentoris.base.BaseEvent;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class ProgressDialogEvent extends BaseEvent {

    public final DialogState dialogState;
    private int messageRes;
    private String message;

    public ProgressDialogEvent(DialogState dialogState) {
        this.dialogState = dialogState;
    }

    public ProgressDialogEvent(@StringRes int messageRes, DialogState state) {
        this(state);
        this.messageRes = messageRes;

    }

    public ProgressDialogEvent(String message, DialogState state) {
        this(state);
        this.message = message;
    }

    public int getMessageRes() {
        return messageRes;
    }

    public String getMessage() {
        return message;
    }

    public enum DialogState {SHOW, HIDE}


}
