package com.texsoft.imentoris.base;

import com.texsoft.imentoris.ApplicationComponent;

/**
 * Created by Rogerio Lavoro on 09/03/2017.
 */

public interface HasComponent<C extends ApplicationComponent> {
    C getComponent();
}
