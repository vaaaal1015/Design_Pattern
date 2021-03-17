package org.ntutssl.termfrequency;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DataStorageManagerTest{
    @Test
    public void getWordsTrueTest(){
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt");
        assertTrue(dsm.getWords().contains("the"));
        assertTrue(dsm.getWords().contains("ebooks"));
    }

    @Test
    public void getWordsFalseTest(){
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt");
        assertFalse(dsm.getWords().contains("The"));
        assertFalse(dsm.getWords().contains("!"));
        assertFalse(dsm.getWords().contains(","));
        assertFalse(dsm.getWords().contains(" "));
        assertFalse(dsm.getWords().contains(""));
        assertFalse(dsm.getWords().contains("_"));
    }
}