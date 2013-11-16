package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.UpsaRestClient;
import com.epam.tver.u2668.upsa.apibeans.Employee;
import com.epam.tver.u2668.upsa.apibeans.Skill;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameInfo {

    @Autowired
    private UpsaRestClient upsaRestClient;

    private List<CharacterInfo> characterList;
    
    private Map<String, Skill[]> skillById;
    
    private final Random random = new Random();

    public void initGame() {
        Employee[] employees = upsaRestClient.getEmployees("tver");
        characterList = new ArrayList<>();
        skillById = new HashMap<>();
        for (int i = 0; (i < employees.length) && (i < 7); i++) {
            CharacterInfo info = new CharacterInfo();
            info.setId(employees[i].getEmployeeId());
            info.setName(employees[i].getFullName());
            skillById.put(employees[i].getEmployeeId(), upsaRestClient.getEmployeeSkills(info.getId()));
            info.setX(random.nextInt(800));
            info.setY(random.nextInt(600));
            characterList.add(info);
        }
    }

    public List<CharacterInfo> getCaracterList() {
        return characterList;
    }
}
