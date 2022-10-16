package com.portfolio.ArgProg.security;

public class AuthResponse {
    private String emial;
    private String accesToken;

    public AuthResponse() {
    }

    public AuthResponse(String emial, String accesToken) {
        this.emial = emial;
        this.accesToken = accesToken;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }
}
