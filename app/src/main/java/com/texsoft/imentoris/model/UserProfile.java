package com.texsoft.imentoris.model;

import com.texsoft.imentoris.util.enums.Provider;
import com.texsoft.imentoris.util.enums.Role;


/**
 * Created by Rogerio Lavoro on 16/03/2017.
 */

public class UserProfile {
    private Role role;
    private Provider provider;
    private String email;
    private String name;

    private UserProfile(Role role, Provider provider, String email, String name) {
        this.role = role;
        this.provider = provider;
        this.email = email;
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public Provider getProvider() {
        return provider;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private Role role;
        private Provider provider;
        private String email;
        private String name;

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setProvider(Provider provider) {
            this.provider = provider;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(role, provider, email, name);
        }
    }
}
