package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HtmlOutputVisitorTest{
    @Test
    public void visitArticleContainArticle(){
        HtmlOutputVisitor htmlOutputVisitor = new HtmlOutputVisitor();
        Article articleL1 = new Article("Level_1", 1);
        Article articleL2 = new Article("Level_2", 2);
        articleL1.add(articleL2);
        htmlOutputVisitor.visitArticle(articleL1);
        assertEquals("<article topic='Level_1'>\n  <article topic='Level_2'>\n  </article>\n</article>\n", htmlOutputVisitor.getResult());
    }

    @Test
    public void visitArticleContainTitleAndParagraph(){
        HtmlOutputVisitor htmlOutputVisitor = new HtmlOutputVisitor();
        Article article = new Article("article", 1);
        Title title = new Title("title", 2);
        Paragraph paragraph = new Paragraph("paragraph");
        article.add(title);
        article.add(paragraph);
        htmlOutputVisitor.visitArticle(article);
        assertEquals("<article topic='article'>\n  <h2>title</h2>\n  <p>paragraph</p>\n</article>\n", htmlOutputVisitor.getResult());
    }
    
    @Test
    public void visitArticle(){
        HtmlOutputVisitor htmlOutputVisitor = new HtmlOutputVisitor();
        Article article = new Article("article", 1);
        htmlOutputVisitor.visitArticle(article);
        assertEquals("<article topic='article'>\n</article>\n", htmlOutputVisitor.getResult());
    }

    @Test
    public void visitTitleH1(){
        HtmlOutputVisitor htmlOutputVisitor = new HtmlOutputVisitor();
        Title title = new Title("title", 1);
        htmlOutputVisitor.visitTitle(title);
        assertEquals("<h1>title</h1>\n", htmlOutputVisitor.getResult());
    }

    @Test
    public void visitTitleH2(){
        HtmlOutputVisitor htmlOutputVisitor = new HtmlOutputVisitor();
        Title title = new Title("title", 2);
        htmlOutputVisitor.visitTitle(title);
        assertEquals("<h2>title</h2>\n", htmlOutputVisitor.getResult());
    }

    @Test
    public void visitParagraph(){
        HtmlOutputVisitor htmlOutputVisitor = new HtmlOutputVisitor();
        Paragraph paragraph = new Paragraph("paragraph");
        htmlOutputVisitor.visitParagraph(paragraph);
        assertEquals("<p>paragraph</p>\n", htmlOutputVisitor.getResult());
    }
}
