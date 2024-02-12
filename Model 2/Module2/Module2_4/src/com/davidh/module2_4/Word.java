package com.davidh.module2_4;

import java.io.*;
import java.util.*;

public class Word {
    public static void main(String[] args) throws IOException {

        /*** BufferReader
         * Reads the longer file without taking too long
         */

        Set<String> result = new HashSet<>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader("C://Users//Dav_Did//Documents//Model 1//Model 2//Module2//Module2_2//src//com//davidh//module2_2//illiad.txt"));
        line = reader.readLine();

        while (line != null) {

            line = line.toLowerCase();
            line = line.replaceAll("[^a-zA-Z ]", "");
            String[] wordInLine = line.split("\s+");

            for (String word : wordInLine) {
                if (!word.isEmpty()) {
                    result.add(word);
                }
            }
            line = reader.readLine();


        }

        reader.close();
        System.out.println(result.size());
    }
}