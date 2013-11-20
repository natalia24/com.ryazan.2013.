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
    private GameInfo gameInfo;

    @Autowired
    private UserContext userContext;

    private final Random random = new Random();

    private Thread gameThread;

    public boolean testUser(String id, String skill) {
        Skill[] ss = gameInfo.getSkillById().get(id);
        for (Skill s : ss) {
            if (s.getSkillName().equals(skill)) {
                return true;
            }
        }
        return false;
    }

    public void initGame() {
        Employee[] employees = upsaRestClient.getEmployees("ryazan");
        List<CharacterInfo> characterList = new ArrayList<>();
        Map<String, Skill[]> skillById = new HashMap<>();
        List<Skill> allSkills = new ArrayList<>();
        List<Skill> requestedTeam = new ArrayList<>();
        for (int i = 0; (i < employees.length) && (i < 7); i++) {
            CharacterInfo info = new CharacterInfo();
            info.setId(employees[i].getEmployeeId());
            info.setName(employees[i].getFullName());
            Skill[] skills = upsaRestClient.getEmployeeSkills(info.getId());
            allSkills.addAll(Arrays.asList(skills));
            skillById.put(employees[i].getEmployeeId(), skills);
            if (skills != null && skills.length > 0) {
                requestedTeam.add(skills[(int) (Math.random() * skills.length)]);
            }
            info.setX(random.nextInt(800));
            info.setY(random.nextInt(600));
            characterList.add(info);
        }

        for (UserInfo info : gameInfo.getLoggedUsers()) {
            Collections.shuffle(allSkills);
            List<Skill> subList = new ArrayList<>(allSkills.subList(0, 5));
            info.setRequestedTeam(subList);

            CharacterInfo uinfo = new CharacterInfo();
            uinfo.setId(info.getId());
            uinfo.setName(info.getName());
            uinfo.setX(random.nextInt(800));
            uinfo.setY(random.nextInt(600));
            uinfo.setNewX(uinfo.getX());
            uinfo.setNewY(uinfo.getY());
            uinfo.setPm(true);
            characterList.add(uinfo);
        }
        gameInfo.setCharacterList(characterList);
    }

    public void goTo(int x, int y) {
        for (CharacterInfo info : gameInfo.getCaracterList()) {
            if (info.getId().equals(userContext.getInfo().getId())) {
                info.setNewX(x);
                info.setNewY(y);
                break;
            }
        }
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
            if (info.isPm()) {
                int xx = Math.abs(info.getNewX() - info.getX());
                int yy = Math.abs(info.getNewY() - info.getY());
                
                if (xx > 20) {
                    int dirx = (info.getNewX() - info.getX()) / xx;
                    info.setX(info.getX() + 15 * dirx);
                } else {
                    info.setNewX(info.getX());
                }
                if (yy > 20) {
                    int diry = (info.getNewY() - info.getY()) / yy;
                    info.setY(info.getY() + 15 * diry);
                } else {
                    info.setNewY(info.getY());
                }
                
            } else {
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
    }

    public Thread getGameThread() {
        return gameThread;
    }

}
