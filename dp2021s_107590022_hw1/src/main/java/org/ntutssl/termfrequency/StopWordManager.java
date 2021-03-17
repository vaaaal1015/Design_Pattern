package org.ntutssl.termfrequency;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class StopWordManager{

    private Set<String> stopWordSet = new HashSet<>();
    private List<String> stopWordList = new ArrayList<>();

    public StopWordManager(String filePath){
        try(Scanner sc = new Scanner(new File(filePath)).useDelimiter(",")){
            while(sc.hasNext()){
                String word = sc.next().toString();
                this.stopWordSet.add(word);
                this.stopWordList.add(word);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("[StopWordManager Exception]: " + e.getMessage());
        }
    }

    public boolean isStopWordList(String word){
        if(word.length() > 1){
            return this.stopWordList.contains(word);
        }
        return true;
    }

    public boolean isStopWordSet(String word){
        if(word.length() > 1){
            return this.stopWordSet.contains(word);
        }
        return true;
    }
}