import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface DocumentElement {
    String render();
}

class TextElement implements DocumentElement {
    private final String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement implements DocumentElement {
    private final String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}

class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return System.lineSeparator();
    }
}

class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}

class FontElement implements DocumentElement {
    private final String text;
    private final String fontStyle;

    public FontElement(String text, String fontStyle) {
        this.text = text;
        this.fontStyle = fontStyle;
    }

    @Override
    public String render() {
        return "[Font: " + fontStyle + "] " + text;
    }
}

class Document {
    private final List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        for (DocumentElement element : documentElements) {
            sb.append(element.render());
        }
        return sb.toString();
    }
}

interface Persistence {
    void save(String data);
}

class FileStorage implements Persistence {
    @Override
    public void save(String data) {
        try (FileWriter writer = new FileWriter("document.txt")) {
            writer.write(data);
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: unable to open file for writing");
        }
    }
}

class DBStorage implements Persistence {
    private static final List<String> database = new ArrayList<>();

    @Override
    public void save(String data) {
        database.add(data);
        System.out.println("Document saved to DBStorage. Total records: " + database.size());
    }
}

class DocumentEdit {
    private final Document document;
    private final Persistence storage;
    private String renderedDocument = "";

    public DocumentEdit(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    public void addFontText(String text, String fontStyle) {
        document.addElement(new FontElement(text, fontStyle));
    }

    public String renderDocument() {
        renderedDocument = document.render();
        return renderedDocument;
    }

    public void saveDocument() {
        storage.save(renderDocument());
    }
}

public class DocumentEditor {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence fileStorage = new FileStorage();
        DocumentEdit editor = new DocumentEdit(document, fileStorage);

        editor.addText("Hello World!");
        editor.addNewLine();
        editor.addFontText("This is a font styled line.", "Bold");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        System.out.println(editor.renderDocument());
        editor.saveDocument();

        Document dbDocument = new Document();
        DocumentEdit dbEditor = new DocumentEdit(dbDocument, new DBStorage());
        dbEditor.addText("Stored in DBStorage");
        dbEditor.addNewLine();
        dbEditor.addFontText("Font class also works here", "Italic");
        dbEditor.saveDocument();
    }
}