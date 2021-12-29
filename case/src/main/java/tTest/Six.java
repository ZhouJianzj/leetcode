package tTest;

public class Six {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            double pow = Math.pow(i, 2);
            String powString = String.valueOf((int) pow);
            String iString = String.valueOf(i);
            String substring = powString.substring(powString.length() - iString.length(), powString.length());
            if (Integer.valueOf(substring) == i){
                System.out.println(i + "---->" + powString);
            }
        }
    }
}
