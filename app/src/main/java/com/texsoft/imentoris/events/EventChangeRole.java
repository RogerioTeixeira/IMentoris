package com.texsoft.imentoris.events;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class EventChangeRole {
    private String role;

    public EventChangeRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
