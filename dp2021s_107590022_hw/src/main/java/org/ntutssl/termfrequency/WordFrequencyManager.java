package org.ntutssl.termfrequency;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class WordFrequencyManager{

    private Map<String, Integer> wordFrequency = new HashMap<String, Integer>();

    public WordFrequencyManager(){

        // for(String word : this.DSM.getWords()){
        //     incrementCount(word);
        // }

    }
    
    public void incrementCount(String word){
        // if(!SWM.isStopWordSet(word))
        this.wordFrequency.put(word, this.getCount(word) + 1);
    }

    public int getNumOfWords(){
        return this.wordFrequency.size();
    }

    public Integer getCount(String word){
        return this.wordFrequency.getOrDefault(word, (Integer)0);
    }

    public Map<String, Integer> getWordFrequencyDescending(){
        List< Map.Entry<String, Integer> > list = new LinkedList< Map.Entry<String, Integer> >( this.wordFrequency.entrySet() );
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Entry<String, Integer> enter : list){
            sortedMap.put(enter.getKey(), enter.getValue());
        }

        return sortedMap;
    }

    public Map<String, Integer> getWordFrequencyAscending(){
        List< Map.Entry<String, Integer> > list = new LinkedList< Map.Entry<String, Integer> >( this.wordFrequency.entrySet() );
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Entry<String, Integer> enter : list){
            sortedMap.put(enter.getKey(), enter.getValue());
        }

        return sortedMap;
    }

    // public void getResult(){
    //     Map<String, Integer> wordFrequenc = new LinkedHashMap<String, Integer>();

    //     if(this.sortingOrder.equals("asc")){
    //         wordFrequenc = this.getWordFrequencyAscending();
    //     } else if(this.sortingOrder.equals("des")){
    //         wordFrequenc = this.getWordFrequencyDescending();
    //     }

    //     int numWordsPrinted = 0;
    //     for(Map.Entry<String, Integer> word : wordFrequenc.entrySet()){
    //         if(numWordsPrinted >= this.range) break;
    //         System.out.println(word.getKey() + ": " + word.getValue());
    //         numWordsPrinted++;
    //     }

    // }
}