package tTest;

import java.io.*;

public class Eight {
    public static void main(String[] args) {
        try {
            copy("D:\\src.txt","D:\\des.txt");
            copy(new File("D:\\src.txt"),new File("D:\\des.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(String srcFilePath,String desFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(srcFilePath));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(desFilePath));
        int a;
        while ( (a = fileInputStream.read()) != -1){
            fileOutputStream.write(a);
        }
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();

    }
    public static void copy(File srcFile, File desFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcFile);
        FileOutputStream fileOutputStream = new FileOutputStream(desFile);
        int a;
        while ( (a = fileInputStream.read()) != -1){
            fileOutputStream.write(a);
        }
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
