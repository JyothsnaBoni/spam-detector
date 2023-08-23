package com.spamdetector;

import com.spamdetector.Email;
import com.spamdetector.EmailSimilarityDetector;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class EmailSimilarityDetectorTest {

  @Test
  public void testSimilarEmails() {
    
    Email email1 = new Email("hello world", "HELLO WORLD");
    Email email2 = new Email("world hello", "WORLD HELLO");

    EmailSimilarityDetector detector = new EmailSimilarityDetector();
    double actual = detector.checkSimilarity(email1, email2);
    
    double expected = 1.0;

    assertEquals(expected, actual, 0.001);

  }

  @Test
  public void testDissimilarEmails() {

    Email email1 = new Email("hello", "hello");
    Email email2 = new Email("world", "world");

    EmailSimilarityDetector detector = new EmailSimilarityDetector();
    double actual = detector.checkSimilarity(email1, email2);
    
    double expected = 0.0;
    System.out.println("actual value : " + actual );

    assertEquals(expected, actual, 0.001);

  }

}