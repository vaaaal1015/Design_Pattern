package org.ntutssl.document;

public interface Document {
    public String getText();

    public default int getLevel() {
        throw new DocumentException("Invalid action: getLevel()");
    }

    public default Document getContent(int index) {
        throw new DocumentException("Invalid action: getContent()");
    }

    public default void add(Document document) {
        throw new DocumentException("Invalid action: add()");
    }
}
