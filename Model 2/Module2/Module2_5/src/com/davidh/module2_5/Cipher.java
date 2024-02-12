package com.davidh.module2_5;

import java.util.HashMap;

public class Cipher {



    public HashMap<Integer,String> createAlphabet(){
        HashMap<Integer,String> alphabet = new HashMap<>();
        Integer num = 0;

        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabet.put(num, String.valueOf(letter));
            num++;
            System.out.println(alphabet.toString());
        }

        return alphabet;
    }

    public String cipher(String originalText, int offset){

        

        return "Placeholder";
    }

}
