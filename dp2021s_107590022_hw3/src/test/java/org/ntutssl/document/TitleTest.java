package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class TitleTest {  

    @Test
    public void getTextTest(){
        Title title = new Title("text");
        assertEquals("text", title.getText());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void getLevelExceptionTest(){
        Document title = new Title("text");
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: getLevel()");
        title.getLevel();        
    }
    @Test
    public void getContentExceptionTest(){
        Document title = new Title("text");
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: getContent()");
        title.getContent(1);        
    }
    @Test
    public void addExceptionTest(){
        Document title = new Title("text");
        Document test = null;
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: add()");
        title.add(test);       
    }

}
