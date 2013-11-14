package ru.tver.hackaton.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.tver.hackaton.beans.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yaroslav_Zabara
 * Date: 11/14/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
@Component("testService")
public class TestService {

    List<TestBean> beans = null;

    public TestService() {
        beans = new ArrayList<TestBean>();
        int size = 100;
        for (int i = 0; i < size; i++) {
            beans.add(new TestBean(i, "message" + i));
        }
    }

    public List<TestBean> getBeans() {
        if (beans.size() != 0) {
            beans.remove(0);
        }
        return beans;
    }
}
