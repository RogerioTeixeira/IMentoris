package com.texsoft.imentoris.events;

import com.texsoft.imentoris.base.BaseEvent;
import com.texsoft.imentoris.util.enums.Page;

/**
 * Created by Rogerio Lavoro on 16/03/2017.
 */

public class PageChangeEvent extends BaseEvent {
    private final Page page;

    public PageChangeEvent(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }
}
