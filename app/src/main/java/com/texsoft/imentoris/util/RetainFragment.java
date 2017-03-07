package com.texsoft.imentoris.util;


import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetainFragment<T> extends Fragment {

    private T data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
