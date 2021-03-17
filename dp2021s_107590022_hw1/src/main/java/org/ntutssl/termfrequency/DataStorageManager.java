package org.ntutssl.termfrequency;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStorageManager{
    private List<String> wordList = new ArrayList<>();
    
    public DataStorageManager(String filePath){
        try(Scanner sc = new Scanner(new File(filePath)).useDelimiter("\\W")){
            while(sc.hasNext()){
                String word = sc.next().toLowerCase();
                if(word.length() > 1)
                    this.wordList.add(word);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("[DataStorageManager Exception]: " + e.getMessage());
        }
    }

    public List<String> getWords(){
        return this.wordList;
    }
}