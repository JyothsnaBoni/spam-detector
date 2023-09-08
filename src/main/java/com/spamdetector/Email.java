package com.spamdetector;

import java.util.Arrays;
import java.util.List;

/**

Representation of an email message.
*/
public class Email {

    private String body;
    private String subject;
    private List<String> words;  
  
    private double spamProbability;
  
    /**

      Constructs an Email object from subject and body strings.
      Also tokenizes body into individual words.
    */
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