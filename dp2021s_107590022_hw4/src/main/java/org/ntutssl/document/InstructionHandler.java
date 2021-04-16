package org.ntutssl.document;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InstructionHandler {
    private Editor editor;
    private Scanner scanner;

    public InstructionHandler(Editor editor) {
        this.editor = editor;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String instruction = new String();
        while (!instruction.equals("exit")) {
            printEditorInstructions();
            instruction = this.scanner.nextLine();
            handleEditorInstructions(instruction);
        }
    }

    private void printEditorInstructions() {
        System.out.println("Please enter the following instruction to start editing:");
        System.out.println("  1. 'add title': to add a title to the editor");
        System.out.println("  2. 'add paragraph': to add a paragraph to the editor");
        System.out.println("  3. 'add article': to add an article to the editor");
        System.out.println("  4. 'find content': to find the specific string in the editor");
        System.out.println("  5. 'output html': to transfer the text to html format");
        System.out.println("  6. 'exit': to exit the program");
    }

    private void handleEditorInstructions(String instruction) {
        try {
            switch (instruction) {
            case "add title":
                this.editor.add(addTitleInstruction());
                break;
            case "add paragraph":
                this.editor.add(addParagraphInstruction());
                break;
            case "add article":
                this.editor.add(addArticleInstruction(0));
                break;
            case "find content":
                findContentInstruction();
                break;
            case "output html":
                outputHtmlInstruction();
                break;
            case "exit":
                break;
            default:
                System.out.println("Invalid Instruction");
                break;
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Document addTitleInstruction() {
        System.out.println("Please enter the information of title:");
        System.out.print("Text of title: ");
        String text = this.scanner.nextLine();
        System.out.print("Size of title: ");
        int size = this.scanner.nextInt();
        this.scanner.nextLine();

        if (size > 6 || size < 1) {
            throw new DocumentException("Invalid Input: The size should be in range 1 to 6");
        }

        Title title = new Title(text, size);
        System.out.println("Title added to the editor.");
        return title;
    }

    private Document addParagraphInstruction() {
        System.out.println("Please enter the information of paragraph:");
        System.out.print("Text of paragraph: ");
        String text = this.scanner.nextLine();
        Paragraph paragraph = new Paragraph(text);
        System.out.println("Paragraph added to the editor.");
        return paragraph;
    }

    private Document addArticleInstruction(int lastLevel) {
        System.out.println("Please enter the information of article:");
        System.out.print("Topic of article: ");
        String topic = this.scanner.nextLine();
        System.out.print("Level of article: ");
        int level = this.scanner.nextInt();
        this.scanner.nextLine();
        if (lastLevel >= level) {
            throw new DocumentException(
                    "Invalid Input: The level should be positive or higher than the level of the current article");
        } else {
            Article article = new Article(topic, level);
            String instruction = new String();
            while (!instruction.equals("exit")) {
                printArticleInstructions();
                instruction = this.scanner.nextLine();
                handleArticleInstructions(instruction, article);
            }
            return article;
        }
    }

    private void printArticleInstructions() {
        System.out.println("Please enter the following instruction to edit the article: ");
        System.out.println("  1. 'add title': to add a title to the article");
        System.out.println("  2. 'add paragraph': to add a paragraph to the article");
        System.out.println("  3. 'add article': to add an article to the article");
        System.out.println("  4. 'exit': to exit the process");
    }

    private void handleArticleInstructions(String instruction, Article article) {

    }

    private void findContentInstruction() {
        System.out.print("Enter the word you want to find: ");
        String target = this.scanner.nextLine();
        FindContentVisitor findContentVisitor = new FindContentVisitor(target);
        Iterator<Document> it = this.editor.iterator();

        while (it.hasNext()) {
            Document document = it.next();
            if (document.getClass() == Title.class) {
                findContentVisitor.visitTitle((Title) document);
            }
            if (document.getClass() == Paragraph.class) {
                findContentVisitor.visitParagraph((Paragraph) document);
            }
            if (document.getClass() == Article.class) {
                findContentVisitor.visitArticle((Article) document);
            }
        }

        List<Document> result = findContentVisitor.getResult();
        for (Document doc : result) {
            System.out.print(doc.toString());
        }
    }

    private void outputHtmlInstruction() {
        HtmlOutputVisitor htmlOutputVisitor = new HtmlOutputVisitor();
        Iterator<Document> it = this.editor.iterator();
        while (it.hasNext()) {
            Document pre = it.next();
            if (pre.getClass() == Title.class) {
                htmlOutputVisitor.visitTitle((Title) pre);
            }
            if (pre.getClass() == Paragraph.class) {
                htmlOutputVisitor.visitParagraph((Paragraph) pre);
            }
            if (pre.getClass() == Article.class) {
                htmlOutputVisitor.visitArticle((Article) pre);
            }
        }
        System.out.println(htmlOutputVisitor.getResult());
    }
}