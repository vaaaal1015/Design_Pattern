package org.ntutssl.termfrequency;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.SortOrder;

public class WordFrequencyManagerStreamTest{

    @Test
    public void getCountTeat(){
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
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
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();

        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("ball");

        assertEquals(3, WFM.getNumOfWords());
    }

    @Test
    public void getNumOfWordsWordNotFoundTest(){
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        boolean detectException = false;
        try{
            WFM.getNumOfWords();
        } catch (Exception e) {
            detectException = true;
        }
        assertTrue(detectException);
    }

    @Test
    public void getWordFrequencyAscendingTest(){
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        SortOrder order = SortOrder.ASCENDING;
        List<String> list = new ArrayList<>();
        list.add("apple: 1\n");
        list.add("ball: 2\n");
        list.add("cat: 3\n");

        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("ball");
        assertTrue(list.equals(WFM.getWordFrequency(order)));
    }

    @Test
    public void getWordFrequencyDescendingTest(){
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        SortOrder order = SortOrder.DESCENDING;
        List<String> list = new ArrayList<>();
        list.add("cat: 3\n");
        list.add("ball: 2\n");
        list.add("apple: 1\n");

        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("cat");
        WFM.incrementCount("ball");
        assertTrue(list.equals(WFM.getWordFrequency(order)));
    }

    @Test
    public void getWordFrequencyOutputAscendingTest() throws FileNotFoundException{
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        String order = "asc";
        List<String> readData = new ArrayList<>();
        IOHandler ioHandler = new IOHandler();

        WFM.incrementCount("apple");
        WFM.incrementCount("dog");
        WFM.incrementCount("ball");
        WFM.incrementCount("dog");
        WFM.incrementCount("cat");
        WFM.incrementCount("dog");
        WFM.incrementCount("cat");
        WFM.incrementCount("dog");
        WFM.incrementCount("cat");
        WFM.incrementCount("ball");

        WFM.output("output/getWordFrequencyOutputAscendingTest.txt", order, 4, ioHandler);

        Scanner sc = new Scanner(new File("output/getWordFrequencyOutputAscendingTest.txt"));
        while(sc.hasNextLine()){
            readData.add(sc.nextLine());
        }

        assertEquals("apple: 1", readData.get(0));
        assertEquals("ball: 2", readData.get(1));
        assertEquals("cat: 3", readData.get(2));
        assertEquals("dog: 4", readData.get(3));
    }

    @Test
    public void getWordFrequencyOutputDescendingTest() throws FileNotFoundException{
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        String order = "des";
        List<String> readData = new ArrayList<>();
        IOHandler ioHandler = new IOHandler();

        WFM.incrementCount("apple");
        WFM.incrementCount("dog");
        WFM.incrementCount("ball");
        WFM.incrementCount("dog");
        WFM.incrementCount("cat");
        WFM.incrementCount("dog");
        WFM.incrementCount("cat");
        WFM.incrementCount("dog");
        WFM.incrementCount("cat");
        WFM.incrementCount("ball");

        WFM.output("output/getWordFrequencyOutputDescendingTest.txt", order, 4, ioHandler);

        Scanner sc = new Scanner(new File("output/getWordFrequencyOutputDescendingTest.txt"));
        while(sc.hasNextLine()){
            readData.add(sc.nextLine());
        }
        assertEquals("dog: 4", readData.get(0));
        assertEquals("cat: 3", readData.get(1));
        assertEquals("ball: 2", readData.get(2));
        assertEquals("apple: 1", readData.get(3)); 
    }

    @Test
    public void getWordFrequencyOutputOrderIsnotAscendingOrDescendingTest(){
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        IOHandler ioHandler = new IOHandler();
        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");
        boolean exception = false;
        try{
            WFM.output("output/test.txt", "error", 1, ioHandler);
        } catch(WordFrequencyException e){
            exception = true;
            assertEquals("The order should be \"asc\" or \"des\".", e.getMessage());
        }
        assertEquals(true, exception);
    }

    @Test
    public void getWordFrequencyOutputRangeSmallerThanOneTest(){
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        IOHandler ioHandler = new IOHandler();
        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");

        boolean exception = false;
        try{
            WFM.output("output/test.txt", "asc", 0, ioHandler);
        } catch(WordFrequencyException e){
            exception = true;
            assertEquals("Out of range! The range should be from 1 to 3.", e.getMessage());
        }
        assertEquals(true, exception);
    }

    @Test
    public void getWordFrequencyOutputRangeBiggerThanTotalWordsTest(){
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        IOHandler ioHandler = new IOHandler();
        WFM.incrementCount("apple");
        WFM.incrementCount("ball");
        WFM.incrementCount("cat");

        boolean exception = false;
        try{
            WFM.output("output/test.txt", "asc", 4, ioHandler);
        } catch(WordFrequencyException e){
            exception = true;
            assertEquals("Out of range! The range should be from 1 to 3.", e.getMessage());
        }
        assertEquals(true, exception);
    }

    @Test
    public void getWordFrequencyOutputWordNotFoundTest(){
        WordFrequencyManagerStream WFM = new WordFrequencyManagerStream();
        IOHandler ioHandler = new IOHandler();

        boolean exception = false;
        try{
            WFM.output("output/test.txt", "asc", 4, ioHandler);
        } catch(WordFrequencyException e){
            exception = true;
            assertEquals("Word not found.", e.getMessage());
        }
        assertEquals(true, exception);
    }
}