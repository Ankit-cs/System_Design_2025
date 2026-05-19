import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


class DocumentEdit{
    private List<String>documentElements;
    private String renderedDocument;
    public DocumentEdit(){
      documentElements=new ArrayList<>();
            renderedDocument="";
    } 
    public void addText(String Text){
        documentElements.add(Text);
    }
    public void addImage(String imagePath){
        documentElements.add(imagePath);
    }
    public String renderDocument(){
        if(documentElements.isEmpty()){
            renderedDocument="Document is empty";
        }
        else{
            StringBuilder sb=new StringBuilder();
            for(String elements:documentElements){
                if(elements.length()>4 && (elements.endsWith(".jpg") || elements.endsWith(".png"))){
                    sb.append("[Image:").append(elements).append("]\n");
                }
                else {
                sb.append(elements).append("\n");
                }
            }
            renderedDocument=sb.toString();

        }
        return renderedDocument;
    }

    public void saveToFile(){
    try{
        FileWriter writer=new FileWriter("document.txt");
        writer.write(renderedDocument);
        writer.close();
        System.out.println("Document saved to document.txt");
             }
        catch(IOException e){
            System.out.println("Error:Unable to open file for Writing");
        }
    }
}

public class DocumentEditor{
    static void main(String [] args){
        // System.out.println("Document Editor");// foc checking the class
        DocumentEdit editor=new DocumentEdit();
        editor.addText("Hello, World");
        editor.addImage("picture.jpg");
        editor.addText("This is a document Editor");
        System.out.println(editor.renderDocument());
        editor.saveToFile();
    }
}