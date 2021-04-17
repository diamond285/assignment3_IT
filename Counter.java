package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Counter {
    public static String read_file(String file_name) throws FileNotFoundException {
        StringBuilder a = new StringBuilder();

        File myObj = new File(file_name);
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            a.append(myReader.nextLine());
        }

        myReader.close();
        return a.toString();
    }

    public static int[] count(String file_name) throws FileNotFoundException {
        int[] a = new int[128];

        File myObj = new File(file_name);
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            for (char x : data.toCharArray()) {
                a[x]++;
            }
        }

        myReader.close();
        return a;
    }

    public static Letter[] parse(int[] count) {
        Letter[] a = new Letter[128];
        for (int i = 0; i < 128; i++) {
            a[i] = new Letter(i, count[i]);
        }
        return a;
    }

    public static Letter[] sorter(Letter[] l) {
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < i; j++) {
                if (l[i].getCount() > l[j].getCount()) {
                    Letter temp = l[i];
                    l[i] = l[j];
                    l[j] = temp;
                }
            }
        }
        return l;
    }

    public static Letter[] deleter(Letter[] l) {
        int i;
        for (i = 0; i < 128; i++) {
            if (l[i].getCount() == 0) {
                break;
            }
        }
        Letter[] news = new Letter[i];
        for (i = i - 1; i >= 0; i--) {
            news[i] = l[i];
        }
        return news;
    }

    public static void save(String s, String file_name) throws IOException {
        FileWriter myWriter = new FileWriter(file_name);
        myWriter.write(s);
        myWriter.close();
    }
}
