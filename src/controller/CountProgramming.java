package controller;

import common.Library;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import view.Menu;

public class CountProgramming {

    Library l = new Library();

    public void run() {
        String str = l.getString("Enter your content: ");
        System.out.println("Count Character: ");
        countCharater(str);
        System.out.println("Count Words");
        countWords(str);
    }

    public void countWords(String str) {
        String[] strArr= new String[100];
        int i=0;
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        StringTokenizer tokenizer = new StringTokenizer(str, " !@#$%^&*()_+-=[]{},.<>?/;:'\"\\|`~");
        while (tokenizer.hasMoreTokens()) {
            strArr[i] = tokenizer.nextToken();
            i++;
        }
        for (int j = 0; j < i; j++) {
            String ch = strArr[j];
            int count = 0;
            for (int k = 0; k < i; k++) {
                if (strArr[k].equals(ch)) {
                    count++;
                }
            }
            lhm.put(ch, count);
        }
        lhm.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
    }

    public void countCharater(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str, " !@#$%^&*()_+-=[]{},.<>?/;:'\"\\|`~");
        StringBuilder sb = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            sb.append(tokenizer.nextToken());
        }
        str = sb.toString();
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }
            lhm.put(ch + "", count);
        }

        lhm.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
    }
}
