package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Writer {
    void writetxt() {
        FileWriter fw = null;
        Scanner S = new Scanner(System.in);
        System.out.println("Enter some Text: ");
        String data = S.nextLine();
        try {
            fw = new FileWriter("FileHandling//abc.txt");
            fw.write(data);
        } catch (IOException io) {
            io.printStackTrace();
        }finally{
            try{
                S.close();
                fw.close();
            }catch(IOException io){
                io.printStackTrace();
            }
        }
    }
}

public class FileExists {
    public static void main(String[] args) {
        Writer w = new Writer();
        w.writetxt();
        File f = new File("D:\\java\\FileHandling\\abc.txt");
        try{
            System.out.println(f.exists());
            System.out.println(f.isDirectory());
            System.out.println(f.isFile());
            System.out.println(f.getName());
            System.out.println(f.getAbsolutePath());
        }catch (Exception e){
            System.out.println("File not found");
        }
    } 
}
