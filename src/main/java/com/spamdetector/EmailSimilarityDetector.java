package com.spamdetector;


public class EmailSimilarityDetector {

    public double checkSimilarity(Email email1, Email email2) {

        int commonWords = 0;
        
        for(String word : email1.getWords()) {
          if(email2.getWords().contains(word)) {
            commonWords++;
          }
        }
      
        return (double)commonWords / (email1.getWords().size() + email2.getWords().size() - commonWords);
      
      }
}