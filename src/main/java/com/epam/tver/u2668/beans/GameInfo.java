package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.apibeans.Skill;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class GameInfo {

    private List<CharacterInfo> characterList;
    private Map<String, Skill[]> skillById;

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
    
}
