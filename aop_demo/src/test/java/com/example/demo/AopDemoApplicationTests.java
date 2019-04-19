package com.example.demo;

import com.example.demo.controller.AopController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopDemoApplicationTests {

    @Autowired
    private AopController aopController1;

    @Test
    public void testAop() {
        this.aopController1.testAop("mykey");
    }

    @Test
    public void testAfterThrowing() {
        this.aopController1.testAfterThrowing("mykey");
    }

    @Test
    public void testAround() {
        this.aopController1.testAround("mykey");
    }

}
