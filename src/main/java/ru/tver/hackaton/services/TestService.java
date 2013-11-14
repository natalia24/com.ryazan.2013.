package ru.tver.hackaton.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.tver.hackaton.beans.TestBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Yaroslav_Zabara
 * Date: 11/14/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
@Component("testService")
public class TestService {

    private List<TestBean> beans = null;
    private Random random = new Random(new Date().getTime());

    public TestService() {
        beans = new ArrayList<TestBean>();
        generate();
    }

    public void generate(){
        beans.clear();
        int size = 10;
        for (int i = 0; i < size; i++) {
            beans.add(new TestBean(i, "message" + random.nextInt()));
        }
    }

    public List<TestBean> getBeans() {
        generate();
        return beans;
    }
}
