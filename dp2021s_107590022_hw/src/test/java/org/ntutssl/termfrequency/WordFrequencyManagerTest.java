package org.ntutssl.termfrequency;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordFrequencyManagerTest{

    @Test
    public void getCountTeat(){
        WordFrequencyManager WFM = new WordFrequencyManager();
        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("ball");


        assertEquals((Integer)1, WFM.getCount("apple"));
        assertEquals((Integer)2, WFM.getCount("ball"));
        assertEquals((Integer)3, WFM.getCount("cat"));
        assertEquals((Integer)0, WFM.getCount("dog"));
    }

    @Test
    public void getNumOfWordsTest(){
        WordFrequencyManager WFM = new WordFrequencyManager();

        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("ball");

        assertEquals(3, WFM.getNumOfWords());
    }

    @Test
    public void getWordFrequencyTest(){
        WordFrequencyManager WFM = new WordFrequencyManager();

        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("ball");

        List< Map.Entry<String, Integer> > list = new ArrayList< Map.Entry<String, Integer> >(WFM.getWordFrequencyAscending().entrySet());
        assertEquals(true, list.get(0).getValue() < list.get(list.size()-1).getValue());
        assertEquals(false, list.get(0).getValue() > list.get(list.size()-1).getValue());

        list = new ArrayList< Map.Entry<String, Integer> >(WFM.getWordFrequencyDescending().entrySet());
        assertEquals(false, list.get(0).getValue() < list.get(list.size()-1).getValue());
        assertEquals(true, list.get(0).getValue() > list.get(list.size()-1).getValue());
    }

}