package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

import org.junit.Test;

public class IOHandlerTest {
    @Test
    public void handleInputAsListFileNotFoundTset(){
        IOHandler ioHandler = new IOHandler();
        boolean exception = false;
        try{
            ioHandler.handleInputAsList("input/file_not_found", ",");
        } catch(WordFrequencyException e){
            exception = true;
            assertEquals("File not found.", e.getMessage());
        }
        assertEquals(true, exception);
    }

    @Test
    public void handleInputAsListReadStopWordTset(){
        IOHandler ioHandler = new IOHandler();
        List<String> list = ioHandler.handleInputAsList("input/stop_words.txt", ",");
        assertTrue(list.contains("a"));
        assertTrue(list.contains("able"));
        assertTrue(list.contains("you"));
        assertTrue(list.contains("your"));
    }

    @Test
    public void handleInputAsSetFileNotFoundTset(){
        IOHandler ioHandler = new IOHandler();
        boolean exception = false;
        try{
            ioHandler.handleInputAsSet("input/file_not_found", ",");
        } catch(WordFrequencyException e){
            exception = true;
            assertEquals("File not found.", e.getMessage());
        }
        assertEquals(true, exception);
    }

    @Test
    public void handleInputAsSetReadStopWordTset(){
        IOHandler ioHandler = new IOHandler();
        Set<String> Set = ioHandler.handleInputAsSet("input/stop_words.txt", ",");
        assertTrue(Set.contains("a"));
        assertTrue(Set.contains("able"));
        assertTrue(Set.contains("you"));
        assertTrue(Set.contains("your"));
    }

    @Test
    public void handleOutputTset() throws FileNotFoundException{
        IOHandler ioHandler = new IOHandler();
        List<String> data = new ArrayList<>();
        List<String> readData = new ArrayList<>();
        
        int range = 20; 
        for(int i = 0; i < range; i++){
            data.add("Line_" + i + "\n");
        }
        ioHandler.handleOutput("output/handleOutputTset.txt", range, data);

        Scanner sc = new Scanner(new File("output/handleOutputTset.txt"));
        while(sc.hasNextLine()){
            readData.add(sc.nextLine() + "\n");
        }

        assertTrue(readData.equals(data));
    }

    @Test
    public void setShouldBeFasterThanList(){
        long ListTime, SetTime;
        IStopWordManager swm = new StopWordManager("input/stop_words.txt", new IOHandler());
        Stopwatch stopwatch = Stopwatch.createStarted();

        for(int i=0;i<100;i++) swm.isStopWordList("your");
        stopwatch.stop();
        ListTime = stopwatch.elapsed(TimeUnit.NANOSECONDS);
        
        stopwatch.reset();
        stopwatch.start();
        for(int i = 0; i < 100; i++) swm.isStopWordSet("your");
        stopwatch.stop();
        SetTime = stopwatch.elapsed(TimeUnit.NANOSECONDS);
        assertTrue(ListTime > SetTime);
    }

}
