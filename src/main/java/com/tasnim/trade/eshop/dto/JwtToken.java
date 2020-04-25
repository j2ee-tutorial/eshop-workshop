package com.tasnim.trade.eshop.dto;

public class JwtToken {
    public final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
