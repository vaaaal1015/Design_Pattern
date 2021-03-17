package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.List;

public class DataStorageManager implements IDataStorageManager{
    private List<String> wordList;

    public DataStorageManager(String filePath, IOHandler ioHandler){
        this.wordList = this.toLowerCase( ioHandler.handleInputAsList(filePath, "[\\W]+") );
    }

    private List<String> toLowerCase(List<String> data){
        List<String> lowerCase = new ArrayList<>();
        for(String word: data){
            lowerCase.add(word.toLowerCase());
        }
        return lowerCase;
    }

    public List<String> getWords(){
        return this.wordList;
    }
}