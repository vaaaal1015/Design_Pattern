package org.ntutssl.document;

public class Title implements Document {
    private String text;
    private int size;

    public Title(String text, int size) {
        this.text = text;
        this.size = size;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTitle(this);
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        return "Title\t\ttext: " + this.text + "\n\t\tsize: " + this.size + "\n";
    }

}