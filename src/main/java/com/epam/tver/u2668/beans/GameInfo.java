package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.apibeans.Skill;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class GameInfo {

    private List<CharacterInfo> characterList;
    private Map<String, Skill[]> skillById;
    private List<UserInfo> loggedUsers;

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

    public synchronized void addLoggedUser(UserInfo response) {
        if (loggedUsers == null) {
            loggedUsers = new ArrayList<>();
        }
        Iterator<UserInfo> iterator = loggedUsers.iterator();
        while (iterator.hasNext()) {
            UserInfo next = iterator.next();
            if (next.getToken().getAdditionalInformation().getUserBean().getPmcId().equals(response.getToken().getAdditionalInformation().getUserBean().getPmcId())) {
                iterator.remove();
            }
        }
        
        loggedUsers.add(response);
    }

    public List<UserInfo> getLoggedUsers() {
        return loggedUsers;
    }

    public Map<String, Skill[]> getSkillById() {
        return skillById;
    }
}
