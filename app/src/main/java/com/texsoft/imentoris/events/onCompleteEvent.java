package com.texsoft.imentoris.events;

import com.texsoft.imentoris.base.BaseEvent;

/**
 * Created by Rogerio Lavoro on 21/03/2017.
 */

public class onCompleteEvent<T> extends BaseEvent {

    private final boolean isSuccefull;
    private final T data;

    public onCompleteEvent(boolean isSuccefull, T data) {
        this.isSuccefull = isSuccefull;
        this.data = data;
    }

    public boolean isSuccefull() {
        return isSuccefull;
    }

    public T getData() {
        return data;
    }
}
