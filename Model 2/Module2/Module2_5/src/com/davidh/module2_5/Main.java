package com.davidh.module2_5;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {



    public static void main(String[] args) {
        System.out.println(cipher("abcdefghijklmnopqrstuvwxyz",-1));
        System.out.println(cipher("abcdefghijklmnopgrstuvwxyz",-7));
        System.out.println(cipher("abcdefghijklmnopqrstuvwxyz",5));
        System.out.println(cipher("aol xbpjr iyvdu mve qbtwz vcly aol flssvd shgf kvn",-5));
        System.out.println(cipher("vjg swkem dtqyp hqz lworu qxgt vjg agnnqy ncba fqi",-2));

        System.out.println(cipher("The Quick Brown Fox Jumps Over The Yellow Lazy Dog",7));

    }

    public static HashMap<String,Integer> createAlphabet(){
        HashMap<String,Integer> alphabet = new HashMap<>();
        Integer num = 0;

        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabet.put(String.valueOf(letter), num);
            num++;
        }


        return alphabet;

    }

    public static String findKey(Integer num, HashMap<String,Integer> alphabet){

        if (num == null) {
            return " ";
        } else if (num > 25) {
            num = num % 26;

        } else if (num < 0) {
            num = 26 + num;

        }

        for (Map.Entry<String, Integer> entry : alphabet.entrySet()) {
            if (entry.getValue().equals(num)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String cipher(String text, Integer offSet){

        text = text.toLowerCase();

        HashMap<String,Integer> alphabet = createAlphabet();
        ArrayList<String> textList = new ArrayList<String>(Arrays.asList(text.split("")));
        ArrayList<Integer> numList = new ArrayList<Integer>();

        for (String item : textList){
            if (!item.equals(" ")){
                numList.add(numList.size(),alphabet.get(item)+offSet);
            } else {
                numList.add(numList.size(), null);
            }

        }

        ArrayList<String> resultList = new ArrayList<String>();


        for (Integer num : numList){
            resultList.add(resultList.size(),findKey(num,alphabet));

        }

        return String.join("",resultList);
    }

}