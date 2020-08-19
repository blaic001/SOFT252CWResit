package controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
 
/**
 * This class extends from OutputStream to redirect output to a JTextArea
 * 
 * Found the solution at www.codejava.net
 * 
 */
public class TextAreaOutputStream_1 extends OutputStream {
    private JTextArea textArea;
     
    public TextAreaOutputStream_1(JTextArea textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    public void print(CharSequence cs) {
        try{
        for (int i = 0; i < cs.length(); i++){
            write(cs.charAt(i));
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
