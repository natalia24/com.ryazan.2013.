package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.UpsaRestClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameInfo {

    @Autowired
    private UpsaRestClient upsaRestClient;

    private List<CharacterInfo> caracterList;

    public void initGame() {
        String employees = upsaRestClient.getEmployees("tver");
        
    }

    public List<CharacterInfo> getCaracterList() {
        return caracterList;
    }
}
