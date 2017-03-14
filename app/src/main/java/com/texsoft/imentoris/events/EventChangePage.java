package com.texsoft.imentoris.events;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class EventChangePage {
    private int numPage;

    public EventChangePage(int numPage) {
        this.numPage = numPage;
    }

    public int getNumPage() {
        return numPage;
    }
}
