package com.epam.tver.u2668.gamelogic;

import com.epam.tver.u2668.beans.CharacterInfo;
import com.epam.tver.u2668.beans.GameInfo;
import com.epam.tver.u2668.beans.UserContext;
import com.epam.tver.u2668.beans.UserInfo;
import com.epam.tver.u2668.upsa.UpsaRestClient;
import com.epam.tver.u2668.upsa.apibeans.Employee;
import com.epam.tver.u2668.upsa.apibeans.Skill;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainLogic {

    @Autowired
    private UpsaRestClient upsaRestClient;

    @Autowired
    private UserContext userCtx;

    @Autowired
    private GameInfo gameInfo;

    private final Random random = new Random();

    private Thread gameThread;

    public void initGame() {
        Employee[] employees = upsaRestClient.getEmployees("tver");
        List<CharacterInfo> characterList = new ArrayList<>();
        Map<String, Skill[]> skillById = new HashMap<>();
        List<Skill> allSkills = new ArrayList<>();
        for (int i = 0; (i < employees.length) && (i < 7); i++) {
            CharacterInfo info = new CharacterInfo();
            info.setId(employees[i].getEmployeeId());
            info.setName(employees[i].getFullName());
            Skill[] skills = upsaRestClient.getEmployeeSkills(info.getId());
            allSkills.addAll(Arrays.asList(skills));
            skillById.put(employees[i].getEmployeeId(), skills);
            info.setX(random.nextInt(800));
            info.setY(random.nextInt(600));
            characterList.add(info);
        }

        for (UserInfo info : gameInfo.getLoggedUsers()) {
            Collections.shuffle(allSkills);
            info.setRequestedTeam(allSkills.subList(0, 5));
        }
        gameInfo.setCharacterList(characterList);
    }

    public void startGame() {
        initGame();
        if (gameThread != null && gameThread.isAlive()) {
            gameThread.interrupt();
        }
        gameThread = new Thread(new GameThread(this));
        gameThread.start();
        gameInfo.setStarted(true);
    }

    public void stopGame() {
        if (gameThread != null) {
            gameThread.interrupt();
        }
    }

    public void step() {
        for (CharacterInfo info : gameInfo.getCaracterList()) {
            info.setX(info.getX() + random.nextInt(20) - 10);
            info.setY(info.getY() + random.nextInt(20) - 10);
            if (info.getX() < 0) {
                info.setX(0);
            }
            if (info.getY() < 0) {
                info.setY(0);
            }
        }
    }

    public Thread getGameThread() {
        return gameThread;
    }

}
