package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;


import org.junit.Test;

public class EditorTest{
    @Test
    public void sizeTest(){
        Editor editor = new Editor();
        assertEquals(0, editor.size());
        Document document = new Title("text", 123);
        editor.add(document);
        assertEquals(1, editor.size());
    }
    @Test
    public void addTest(){
        Editor editor = new Editor();
        Document document = new Title("text", 123);
        editor.add(document);
        assertEquals(document, editor.iterator().next());
    }

    @Test
    public void iteratorTest(){
        Editor editor = new Editor();
        Iterator<Document> it = editor.iterator();
        assertFalse(it.hasNext());
        Document document = new Title("text", 123);
        editor.add(document);
        it = editor.iterator();
        assertTrue(it.hasNext());
        assertEquals(document, it.next());
        assertFalse(it.hasNext());
    }
}