package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.UpsaRestClient;
import com.epam.tver.u2668.upsa.apibeans.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameInfo {

    @Autowired
    private UpsaRestClient upsaRestClient;

    private List<CharacterInfo> caracterList;
    
    private final Random random = new Random();

    public void initGame() {
        Employee[] employees = upsaRestClient.getEmployees("tver");
        caracterList = new ArrayList<>();
        for (int i = 0; (i < employees.length) && (i < 7); i++) {
            CharacterInfo info = new CharacterInfo();
            info.setId(employees[i].getEmployeeId());
            info.setName(employees[i].getFullName());
            info.setSkills(Arrays.asList(upsaRestClient.getEmployeeSkills(info.getId())));
            info.setX(random.nextInt(800));
            info.setY(random.nextInt(600));
        }
    }

    public List<CharacterInfo> getCaracterList() {
        return caracterList;
    }
}
