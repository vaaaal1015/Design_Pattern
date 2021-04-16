package org.ntutssl.document;

import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class NullIteratorTest{
    @Test
    public void hasNextTest(){
        NullIterator nullIterator = new NullIterator();
        assertFalse(nullIterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextTest(){
        NullIterator nullIterator = new NullIterator();
        nullIterator.next();
    }
}