package org.ntutssl.termfrequency;

import java.util.Map;

public class WordFrequencyController{
    public static void main(String[] args){

        StopWordManager SWM = new StopWordManager(args[0]);
        DataStorageManager DSM = new DataStorageManager(args[1]);
        int range = Integer.parseInt(args[2]);
        String order = new String(args[3]);

        WordFrequencyManager WFM = new WordFrequencyManager();
        Map<String, Integer> wordFrequency;

        for(String word : DSM.getWords()){
            if(!SWM.isStopWordSet(word))
                WFM.incrementCount(word);
        }

        switch (args[3]){
            case "asc":
                wordFrequency =  WFM.getWordFrequencyAscending();
                break;

            case "des":
                wordFrequency = WFM.getWordFrequencyDescending();
                break;

            default:
                System.out.println("Order should be asc or des");
                return;
        }


        if(range < 1 || range > WFM.getNumOfWords()){
            System.out.println("Range should be any positive integer less than the total number of distinct words. (e.g. 1, 2, 3, ...)");
            return;
        }

        int numWordsPrinted = 0;
        for(Map.Entry<String, Integer> word : wordFrequency.entrySet()){
            if(numWordsPrinted >= range) break;
            System.out.println(word.getKey() + ": " + word.getValue());
            numWordsPrinted++;
        }

    }
}