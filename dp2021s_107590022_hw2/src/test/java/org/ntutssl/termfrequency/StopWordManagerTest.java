package org.ntutssl.termfrequency;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import com.google.common.base.Stopwatch;

import org.junit.Test;

public class StopWordManagerTest{

    // Testing for List
    @Test
    public void isStopWordListReadFileTest(){
        IOHandler ioHandler = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt", ioHandler);
        assertTrue(swm.isStopWordList("a"));
        assertTrue(swm.isStopWordList("able"));
        assertTrue(swm.isStopWordList("you"));
        assertTrue(swm.isStopWordList("your"));
    }

    @Test
    public void isStopWordListSingleCharacterTrueTest(){
        IOHandler ioHandler = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt", ioHandler);
        assertTrue(swm.isStopWordList("g"));
        assertTrue(swm.isStopWordList("k"));
    }

    @Test
    public void isStopWordListSingleCharacterFalseTest(){
        IOHandler ioHandler = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt", ioHandler);
        assertFalse(swm.isStopWordList("gg"));
        assertFalse(swm.isStopWordList("kk"));
    }


    // Testing for Set
    @Test
    public void isStopWordSetReadFileTest(){
        IOHandler ioHandler = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt", ioHandler);
        assertTrue(swm.isStopWordSet("a"));
        assertTrue(swm.isStopWordSet("able"));
        assertTrue(swm.isStopWordSet("you"));
        assertTrue(swm.isStopWordSet("your"));
    }

    @Test
    public void isStopWordSetSingleCharacterTrueTest(){
        IOHandler ioHandler = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt", ioHandler);
        assertTrue(swm.isStopWordSet("g"));
        assertTrue(swm.isStopWordSet("k"));
    }

    @Test
    public void isStopWordSetSingleCharacterFalseTest(){
        IOHandler ioHandler = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt", ioHandler);
        assertFalse(swm.isStopWordSet("gg"));
        assertFalse(swm.isStopWordSet("kk"));
    }

    // @Test
    // public void compareTheExecutionTimeOfSetAndList(){
    //     IOHandler ioHandler = new IOHandler();
    //     StopWordManager swm = new StopWordManager("input/stop_words.txt", ioHandler);
    //     long startTime;
    //     long SetTime;
    //     long ListTime;
        
    //     // stopwatch.reset();
    //     // stopwatch.start();
    //     // for(int i = 0; i < 100; i++)
    //     //     swm.isStopWordSet("test");
    //     // stopwatch.stop();
    //     // // System.out.println("Execution time in nanoseconds using Set: " + stopwatch.elapsed(TimeUnit.NANOSECONDS));
    //     // SetTimeCost = stopwatch.elapsed(TimeUnit.NANOSECONDS);

    //     // stopwatch.reset();
    //     // stopwatch.start();
    //     // for(int i = 0; i < 100; i++)
    //     //     swm.isStopWordList("test");
    //     // stopwatch.stop();
    //     // // System.out.println("Execution time in nanoseconds using List: " + stopwatch.elapsed(TimeUnit.NANOSECONDS));
    //     // ListTimeCost = stopwatch.elapsed(TimeUnit.NANOSECONDS);

    //     // assertTrue(ListTimeCost > SetTimeCost);

    //     startTime = System.nanoTime();
    //     swm.isStopWordSet("a");
    //     SetTime = System.nanoTime() - startTime;

    //     startTime = System.nanoTime();
    //     swm.isStopWordList("a");
    //     ListTime = System.nanoTime() - startTime;

    //     System.out.println(SetTime);
    //     System.out.println(ListTime);
    // }
}