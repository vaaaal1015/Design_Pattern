package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StopWordManagerTest{
    @Test
    public void isStopWordSetTest(){
        StopWordManager swm = new StopWordManager("input/stop_words.txt");
        assertEquals(true, swm.isStopWordSet("a"));
        assertEquals(true, swm.isStopWordSet("able"));
        assertEquals(true, swm.isStopWordSet("you"));
        assertEquals(true, swm.isStopWordSet("your"));
        assertEquals(false, swm.isStopWordSet("hello"));
    }
    

    @Test
    public void isStopWordListTest(){
        StopWordManager swm = new StopWordManager("input/stop_words.txt");
        assertEquals(true, swm.isStopWordList("a"));
        assertEquals(true, swm.isStopWordList("able"));
        assertEquals(true, swm.isStopWordList("you"));
        assertEquals(true, swm.isStopWordList("your"));
        assertEquals(false, swm.isStopWordList("hello"));
    }
}