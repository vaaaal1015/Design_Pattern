package org.ntutssl.termfrequency;

import java.util.List;
import javax.swing.SortOrder;

public interface IWordFrequencyManager{
    public void incrementCount(String word);
    public int getNumOfWords();
    public Integer getCount(String word);
    public List<String> getWordFrequency(SortOrder order);
    public void output(String outputPath, String order, int range, IOHandler handler);
}
