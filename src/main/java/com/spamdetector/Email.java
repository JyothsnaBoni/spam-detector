package com.spamdetector;

import java.util.Arrays;
import java.util.List;

public class Email {

    private String body;
    private String subject;
    private List<String> words;  
  
    private double spamProbability;
  
    public Email(String body, String subject) {
      this.body = body;
      this.subject = subject;
      
      // tokenize into words
      words = Arrays.asList(body.split(" "));
    }
  
    public String getBody() {
      return body;
    }
  
    public String getSubject() {
      return subject; 
    }
  
    public List<String> getWords() {
      return words;
    }
  
    public double getSpamProbability() {
      return spamProbability;
    }
  
    public void setSpamProbability(double spamProbability) {
      this.spamProbability = spamProbability;
    }
  
  }