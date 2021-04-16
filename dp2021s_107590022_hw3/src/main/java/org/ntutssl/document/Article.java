package org.ntutssl.document;

import java.util.ArrayList;
import java.util.List;

public class Article implements Document {  
    private String topic;
    private int level;
    private List<Document> documentList;

    public Article(String topic, int level) {
        this.topic = topic;
        this.level = level;
        this.documentList = new ArrayList<Document>();
    }

    @Override
    public Document getContent(int index) {
        return this.documentList.get(index);
    }

    public String getText() {
        return this.topic;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
    
    
    @Override
    public void add(Document document) {
        if(document.getClass() == Article.class){
            if(document.getLevel() < this.getLevel()){
                throw new DocumentException("Can not add lower level into higher level");
            }
        }
        this.documentList.add(document);
    }
}
