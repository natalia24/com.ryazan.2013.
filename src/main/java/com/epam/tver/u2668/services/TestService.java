package com.epam.tver.u2668.services;

import org.springframework.stereotype.Component;
import com.epam.tver.u2668.beans.TestBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component("testService")
public class TestService {

    private List<TestBean> beans = null;
    private Random random = new Random(new Date().getTime());

    public TestService() {
        beans = new ArrayList<>();
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
