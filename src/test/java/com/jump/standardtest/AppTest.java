package com.jump.standardtest;

//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    //    /**
    //     * Rigorous Test :-)
    //     */
    @Test
    public void shouldAnswerWithTrue() {
        String TOPIC_SPLIT = "\\(,|;|:|#\\)";
        String str = "a,b,c,d";
        String[] strings = str.split(TOPIC_SPLIT);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void testQueue() {
        Queue<String> records = new LinkedBlockingQueue<>();
        records.add("a");
        String s = records.poll();
        System.out.println(s);
        String s1 = records.poll();
        System.out.println(s1);
        System.out.println("end");
    }
}
