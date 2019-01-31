package indi.fao;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOJO 利用此类得到文件的流
 */
public class HandleWordTestType {

    File fileDir;
    String fileName;
    File finallyFileAdress;
    FileReader fileReader = null;
    
    public HandleWordTestType(File fileDir, String fileName) {
        this.fileDir = fileDir;
        this.fileName = fileName;
        this.finallyFileAdress = new File(fileDir, fileName);
        try {
            this.fileReader = new FileReader(finallyFileAdress);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HandleWordTestType.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    //  testThisClass
    public static void main(String[] args) {
        char c[] = new char[10000];
        Reader fileReader = new HandleWordTestType(new File("course\\\\englishType\\\\wordTest"),
                "04.txt").getFileReader();
        try {
            fileReader.read(c);
        } catch (IOException ex) {
            Logger.getLogger(HandleWordTestType.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = new String(c);
        System.out.println(str);    
        
    }

}
