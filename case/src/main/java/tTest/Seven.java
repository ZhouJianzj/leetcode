package tTest;

import java.io.FileReader;
import java.io.Reader;

public class Seven {
    public static void main(String[] args) {
        String file = "D:/report_data2.txt";
        String find = "down";
        try {
            int n = countWords(file, find);
            System.out.println(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int countWords(String file, String find) throws Exception {
        int count = 0;
        try {
            Reader in = new FileReader(file);
            int c;
            while ((c = in.read()) != -1) {
                while (c == find.charAt(0)) {
                    for (int i = 1; i < find.length(); i++) {
                        c = in.read();
                        if (c != find.charAt(i)) {
                            break;
                        }
                        if (i == find.length() - 1) {
                            count++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
