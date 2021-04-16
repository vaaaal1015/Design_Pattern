package org.ntutssl.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Editor {
    private List<Document> editor;

    public Editor() {
        editor = new ArrayList<Document>();
    }

    public void add(Document document) {
        editor.add(document);
    }

    public int size() {
        return editor.size();
    }

    public Iterator<Document> iterator() {
        return editor.iterator();
    }
}
