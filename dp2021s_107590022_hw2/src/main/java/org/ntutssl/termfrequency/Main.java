package org.ntutssl.termfrequency;

public class Main {
    public static void main(String[] args){
        String stopWordFilePath = args[0];
        String testFilePath = args[1];
        String outputFilePath = args[2];
        Integer range = Integer.parseInt(args[3]);
        String order = args[4];


        IOHandler ioHandler = new IOHandler();
        IStopWordManager swm = new StopWordManager(stopWordFilePath, ioHandler);
        IDataStorageManager dsm = new DataStorageManager(testFilePath, ioHandler);
        IWordFrequencyManager wfm = new WordFrequencyManager();
        WordFrequencyController wfc = new WordFrequencyController(ioHandler, swm, dsm, wfm);
    
        wfc.run(order, range, outputFilePath);
    }
}