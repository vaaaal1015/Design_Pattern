package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class ParagraphTest {
    @Test
    public void getTextTest(){
        Paragraph paragraph = new Paragraph("text");
        assertEquals("text", paragraph.getText());
    }
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void getLevelExceptionTest(){
        Document paragraph = new Paragraph("text");
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: getLevel()");
        paragraph.getLevel();        
    }
    @Test
    public void getContentExceptionTest(){
        Document paragraph = new Paragraph("text");
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: getContent()");
        paragraph.getContent(1);        
    }
    @Test
    public void addExceptionTest(){
        Document paragraph = new Paragraph("text");
        Document test = null;
        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Invalid action: add()");
        paragraph.add(test);       
    }
    @Test
    public void toStringTest(){
        Paragraph paragraph = new Paragraph("text");
        assertEquals("Paragraph\ttext: text\n", paragraph.toString());
    }
}
