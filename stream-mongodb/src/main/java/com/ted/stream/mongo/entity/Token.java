package com.ted.stream.mongo.entity;

import java.io.Serializable;

public class Token implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    public Token() {
    }

    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
