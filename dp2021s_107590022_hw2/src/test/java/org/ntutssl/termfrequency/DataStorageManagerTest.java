package org.ntutssl.termfrequency;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DataStorageManagerTest{
    @Test
    public void getWordsTrueTest(){
        IOHandler ioHandler = new IOHandler();
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt", ioHandler);
        assertTrue(dsm.getWords().contains("the"));
        assertTrue(dsm.getWords().contains("ebooks"));
    }

    @Test
    public void getWordsUppercaseTest(){
        IOHandler ioHandler = new IOHandler();
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt", ioHandler);
        assertFalse(dsm.getWords().contains("The"));
        assertFalse(dsm.getWords().contains("eBooks"));
    }

    @Test
    public void getWordsSymbolTest(){
        IOHandler ioHandler = new IOHandler();
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt", ioHandler);
        assertFalse(dsm.getWords().contains("!"));
        assertFalse(dsm.getWords().contains(","));
        assertFalse(dsm.getWords().contains("_"));
        assertFalse(dsm.getWords().contains("."));
    }

    @Test
    public void getWordsBlankTest(){
        IOHandler ioHandler = new IOHandler();
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt", ioHandler);
        assertFalse(dsm.getWords().contains(" "));
    }
    
    @Test
    public void getWordsSingleCharacterTest(){
        IOHandler ioHandler = new IOHandler();
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt", ioHandler);
        assertTrue(dsm.getWords().contains("a"));
    }

    @Test
    public void getWordsEmptyTest(){
        IOHandler ioHandler = new IOHandler();
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt", ioHandler);
        assertFalse(dsm.getWords().contains(""));
    }
}