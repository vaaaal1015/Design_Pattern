package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArticleTest {  
    @Test
    public void getTextTest() {
        Article article = new Article("text", 20);
        assertEquals("text", article.getText());
    }

    @Test
    public void getLevelTest() {
        Article article = new Article("text", 20);
        assertEquals(20, article.getLevel());
    }

    @Test
    public void addAndGetContentTest() {
        Article article = new Article("text", 20);
        Document title = new Title("text1");
        Document paragraph = new Paragraph("text2");
        article.add(title);
        article.add(paragraph);
        assertEquals(title, article.getContent(0));
        assertEquals(paragraph, article.getContent(1));
    }


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void addLowerLevelIntoHighterLevelTest() {
        Document articleLevel20 = new Article("text", 20);
        Document articleLevel10 = new Article("text", 10);

        exceptionRule.expect(DocumentException.class);
        exceptionRule.expectMessage("Can not add lower level into higher level");

        articleLevel20.add(articleLevel10);        
    }

    @Test
    public void addHighterLevelIntoLowerLevelTest() {
        Document articleLevel20 = new Article("text", 20);
        Document articleLevel10 = new Article("text", 10);

        articleLevel10.add(articleLevel20);   
    }

}
