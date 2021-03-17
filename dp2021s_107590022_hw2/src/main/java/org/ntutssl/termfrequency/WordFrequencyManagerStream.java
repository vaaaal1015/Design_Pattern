package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WordFrequencyManagerStream implements IWordFrequencyManager {
    private Map<String, Integer> wordFrequency;
    private IOHandler ioHandler;

    public WordFrequencyManagerStream(){
        this.wordFrequency = new HashMap<String, Integer>();
    }

    public void incrementCount(String word){
        this.wordFrequency.put(word, this.getCount(word) + 1);
    }

    public int getNumOfWords(){
        
        if(this.wordFrequency.isEmpty()){
            throw new WordFrequencyException("Word not found.");
        }

        return this.wordFrequency.size();
    }

    public Integer getCount(String word){
        return this.wordFrequency.getOrDefault(word, (Integer)0);
    }

    private List<String> sort(SortOrder order) { 
        List< Map.Entry<String, Integer> > list = new ArrayList<>(this.wordFrequency.entrySet());
        List<String> sortedList = new ArrayList<>();

        if(order == SortOrder.ASCENDING){
            list = list.stream().sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue)).collect(Collectors.toList());
        }else if(order == SortOrder.DESCENDING){
            list = list.stream().sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()).collect(Collectors.toList());
        }
        
        for(Map.Entry<String, Integer> map: list){
            sortedList.add(map.getKey() + ": " + map.getValue().toString() + "\n");
        }
        
        return sortedList;
    }

    public List<String> getWordFrequency(SortOrder order){
        return this.sort(order);
    }

    public void output(String outputPath, String order, int range, IOHandler handler){
        ioHandler = handler;
        SortOrder sortOrder = SortOrder.UNSORTED;

        // try {
        //     if(order.equals("asc")){
        //         sortOrder = SortOrder.ASCENDING;
        //     }else if(order.equals("des")){
        //         sortOrder = SortOrder.DESCENDING;
        //     }else{
        //         throw new WordFrequencyException("The order should be \"asc\" or \"des\".");
        //     }
            
        //     if(range > getNumOfWords() || range < 1){
        //         throw new WordFrequencyException("Out of range! The range should be from 1 to " + getNumOfWords() + ".");
        //     }

        // } catch (WordFrequencyException e) {
        //     System.out.print(e.getMessage() + "\n");
        // }
        
        if(range > getNumOfWords() || range < 1){
            throw new WordFrequencyException("Out of range! The range should be from 1 to " + getNumOfWords() + ".");
        }

        if(order.equals("asc")){
            sortOrder = SortOrder.ASCENDING;
        }else if(order.equals("des")){
            sortOrder = SortOrder.DESCENDING;
        }else{
            throw new WordFrequencyException("The order should be \"asc\" or \"des\".");
        }
        
        

        List<String> data = this.getWordFrequency(sortOrder);
        ioHandler.handleOutput(outputPath, range, data);
    }
}