package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class FindContentVisitorTest{
    @Test
    public void visitParagraphTest(){
        FindContentVisitor find = new FindContentVisitor("test");
        Paragraph paragraph = new Paragraph("TEST");
        find.visitParagraph(paragraph);
        assertTrue(find.getResult().contains(paragraph));
    }

    @Test
    public void visitArticleTest(){
        FindContentVisitor find = new FindContentVisitor("test");
        Article article = new Article("test", 1);
        Document title = new Title("test", 10);
        Document article2 = new Article("test", 2);
        Document title2 = new Title("test", 10);
        
        article2.add(title2);
        article.add(title);
        article.add(article2);
        
        find.visitArticle(article);
        List<Document> result = find.getResult();
        
        assertEquals(article, result.get(0));
        assertEquals(title, result.get(1));
        assertEquals(article2, result.get(2));
        assertEquals(title2, result.get(3));
    }

    @Test
    public void visitTitleTest(){
        FindContentVisitor find = new FindContentVisitor("test");
        Title title = new Title("test", 1);
        find.visitTitle(title);
        assertTrue(find.getResult().contains(title));
    }
}
