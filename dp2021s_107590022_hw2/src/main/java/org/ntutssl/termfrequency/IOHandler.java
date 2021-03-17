package org.ntutssl.termfrequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IOHandler {
    private List<String> wordList;
    private Set<String> wordSet;

    public IOHandler() { }

    public List<String> handleInputAsList(String filePath, String pattern) {
        wordList = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(filePath)).useDelimiter(pattern)){
            while(sc.hasNext()){
                this.wordList.add(sc.next().toLowerCase());
            }
        }
        catch (FileNotFoundException e) {
            throw new WordFrequencyException("File not found.");
        }

        return wordList;
    }

    public Set<String> handleInputAsSet(String filePath, String pattern) {
        wordSet = new HashSet<>();
        try(Scanner sc = new Scanner(new File(filePath)).useDelimiter(pattern)){
            while(sc.hasNext()){
                this.wordSet.add(sc.next().toLowerCase());
            }
        }
        catch (FileNotFoundException e) {
            throw new WordFrequencyException("File not found.");
        }

        return wordSet;
    }

    public void handleOutput(String outputPath, int range, List<String> data){
        try(FileWriter fw = new FileWriter(outputPath)){
            int printCount = 0;
            for(String line: data){
                if(printCount == range) break;
                fw.write(line);
                printCount++;
            }
            fw.flush();
        } catch (IOException e) {
            throw new WordFrequencyException(e.getMessage(), e);
        }
    }
}
