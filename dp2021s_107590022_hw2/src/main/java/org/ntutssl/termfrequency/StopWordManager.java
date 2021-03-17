package org.ntutssl.termfrequency;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class StopWordManager implements IStopWordManager{

    private Set<String> stopWordSet = new HashSet<>();
    private List<String> stopWordList = new ArrayList<>();

    public StopWordManager(String filePath, IOHandler ioHandler){
        stopWordList = ioHandler.handleInputAsList(filePath, ",");
        stopWordSet = ioHandler.handleInputAsSet(filePath, ",");
    }

    public boolean isStopWordList(String word){
        return (word.length() > 1 ? this.stopWordList.contains(word) : true);
    }

    public boolean isStopWordSet(String word){
        return (word.length() > 1 ? this.stopWordSet.contains(word) : true);
    }
}