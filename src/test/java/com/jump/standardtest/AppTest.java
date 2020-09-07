package com.jump.standardtest;

//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;

import org.junit.Test;

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
        for (String s : strings){
            System.out.println(s);
        }
    }
}
