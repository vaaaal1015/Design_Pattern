package org.ntutssl.document;

public class Paragraph implements Document {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
        
    }

    @Override
    public String toString(){
        return "Paragraph\ttext: " + this.text + "\n";
    }
}
