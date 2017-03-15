package com.texsoft.imentoris.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogerio Lavoro on 15/03/2017.
 */

public class BaseEvent<T> {
    private T data;

    private List<Class<?>> classReceiverList = new ArrayList<>();

    public void addClassFilter(Class<?> classReceiver) {
        classReceiverList.add(classReceiver);
    }

    public boolean isEventFor(Object obj) {
        if (classReceiverList.isEmpty()) {
            return true;
        }
        return classReceiverList.contains(obj.getClass());
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
