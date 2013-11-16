package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.apibeans.Skill;
import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import java.util.List;

public class UserInfo {

    private String name;
    private String id;
    private TokenResponse token;
    private List<Skill> requestedTeam;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TokenResponse getToken() {
        return token;
    }

    public void setToken(TokenResponse token) {
        this.token = token;
    }

    public List<Skill> getRequestedTeam() {
        return requestedTeam;
    }

    public void setRequestedTeam(List<Skill> requestedTeam) {
        this.requestedTeam = requestedTeam;
    }

}
