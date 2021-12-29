package tTest;

import java.util.Arrays;

public class Five {
    public static void main(String[] args) {
        String alpha_beta_double = "alpha_beta_double";
        String[] s = alpha_beta_double.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            stringBuilder.append(s[i].substring(0, 1).toUpperCase() + s[i].substring(1));
        }
        System.out.println(stringBuilder);
    }
}
