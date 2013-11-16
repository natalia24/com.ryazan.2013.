package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.apibeans.Skill;
import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class GameInfo {

    private List<CharacterInfo> characterList;
    private Map<String, Skill[]> skillById;
    private List<TokenResponse> loggedUsers;

    private boolean started = false;

    public List<CharacterInfo> getCaracterList() {
        return characterList;
    }

    public void setCharacterList(List<CharacterInfo> characterList) {
        this.characterList = characterList;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public synchronized void addLoggedUser(TokenResponse response) {
        if (loggedUsers == null) {
            loggedUsers = new ArrayList<>();
        }
        Iterator<TokenResponse> iterator = loggedUsers.iterator();
        while (iterator.hasNext()) {
            TokenResponse next = iterator.next();
            if (next.getAdditionalInformation().getUserBean().getPmcId().equals(response.getAdditionalInformation().getUserBean().getPmcId())) {
                iterator.remove();
            }
        }
        
        loggedUsers.add(response);
    }

    public List<TokenResponse> getLoggedUsers() {
        return loggedUsers;
    }

}
