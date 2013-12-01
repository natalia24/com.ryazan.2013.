package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.apibeans.Skill;
import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import java.util.ArrayList;
import java.util.List;

public class UserInfo {

    private String name;
    private String id;
    private List<Skill> requestedTeam = new ArrayList<>();
    private final List<TokenResponse> usersOK = new ArrayList<>();

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

    public List<Skill> getRequestedTeam() {
        return requestedTeam;
    }

    public void setRequestedTeam(List<Skill> requestedTeam) {
        this.requestedTeam = requestedTeam;
    }

    public List<TokenResponse> getUsersOK() {
        return usersOK;
    }

}
