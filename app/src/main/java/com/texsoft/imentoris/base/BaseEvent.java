package com.texsoft.imentoris.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogerio Lavoro on 15/03/2017.
 */

public class BaseEvent {

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
}
