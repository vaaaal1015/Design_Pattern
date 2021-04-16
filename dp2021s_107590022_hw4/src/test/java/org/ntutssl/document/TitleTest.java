package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class TitleTest {  

    @Test
    public void getTextTest(){
        Title title = new Title("text", 1);
        assertEquals("text", title.getText());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void getLevelExceptionTest(){
        Document title = new Title("text", 1);
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: getLevel()");
        title.getLevel();        
    }
    @Test
    public void getContentExceptionTest(){
        Document title = new Title("text", 1);
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: getContent()");
        title.getContent(1);        
    }
    @Test
    public void addExceptionTest(){
        Document title = new Title("text", 1);
        Document test = null;
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: add()");
        title.add(test);       
    }

    @Test
    public void getSizeTest(){
        Title title = new Title("text", 1);
        assertEquals(1, title.getSize());
    }

    @Test
    public void toStringTest() {
        Title title = new Title("text", 1);
        assertEquals("Title\t\ttext: text\n\t\tsize: 1\n", title.toString());
    }

}
