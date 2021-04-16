package org.ntutssl.document;

import java.util.Iterator;

public class HtmlOutputVisitor implements Visitor<String>{
    private String result;

    public HtmlOutputVisitor() {
        this.result = new String();
    }

    public void visitParagraph(Paragraph paragraph) {
        result += "<p>" + paragraph.getText() + "</p>\n";
    }

    public void visitTitle(Title title) {
        result += "<h" + title.getSize() + ">" + title.getText() + "</h" + title.getSize() + ">\n";
    }

    public void visitArticle(Article article) {
        result += "<article topic=\'" + article.getText() + "\'>\n";
        
        Iterator<Document> it = article.iterator();
        while(it.hasNext()){
            result += getBlank(article.getLevel());
            Document doc = it.next();
            if(doc.getClass() == Title.class){
                this.visitTitle((Title)doc);
            }
            if(doc.getClass() == Paragraph.class){
                this.visitParagraph((Paragraph)doc);
            }
            if(doc.getClass() == Article.class){
                this.visitArticle((Article)doc);
            }
        }

        result += getBlank(article.getLevel() - 1) + "</article>\n";
    }

    private String getBlank(int level){
        String blank = new String();
        for(int i = 0; i < level; i++){
            blank += "  ";
        }
        return blank;
    }

    public String getResult() {
        return this.result;
    }
}
