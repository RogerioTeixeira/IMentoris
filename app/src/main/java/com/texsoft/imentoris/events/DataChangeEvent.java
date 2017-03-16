package com.texsoft.imentoris.events;

import com.texsoft.imentoris.base.BaseEvent;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class DataChangeEvent<T> extends BaseEvent {

    private T data;

    public DataChangeEvent(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
