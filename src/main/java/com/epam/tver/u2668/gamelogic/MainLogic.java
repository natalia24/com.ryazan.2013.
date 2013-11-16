package com.epam.tver.u2668.gamelogic;

import com.epam.tver.u2668.beans.CharacterInfo;
import com.epam.tver.u2668.beans.GameInfo;
import com.epam.tver.u2668.upsa.UpsaRestClient;
import com.epam.tver.u2668.upsa.apibeans.Employee;
import com.epam.tver.u2668.upsa.apibeans.Skill;
import java.util.ArrayList;
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
    private GameInfo gameInfo;
    
    private final Random random = new Random();

    private Thread gameThread;

    public void initGame() {
        Employee[] employees = upsaRestClient.getEmployees("tver");
        List<CharacterInfo> characterList = new ArrayList<>();
        Map<String, Skill[]> skillById = new HashMap<>();
        for (int i = 0; (i < employees.length) && (i < 7); i++) {
            CharacterInfo info = new CharacterInfo();
            info.setId(employees[i].getEmployeeId());
            info.setName(employees[i].getFullName());
            skillById.put(employees[i].getEmployeeId(), upsaRestClient.getEmployeeSkills(info.getId()));
            info.setX(random.nextInt(800));
            info.setY(random.nextInt(600));
            characterList.add(info);
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

    public void step() {
        System.out.println("================= step!!");
        for (CharacterInfo info : gameInfo.getCaracterList()) {
            info.setX(info.getX() + random.nextInt(20) - 10);
            info.setY(info.getY() + random.nextInt(20) - 10);
        }
    }

    public Thread getGameThread() {
        return gameThread;
    }
    
}
