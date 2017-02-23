package com.texsoft.imentoris.iterator;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

public interface LoginIterator {
    interface OnCompleteListener<T> {
        void onComplete(T args);
    }
}
