package com.spamdetector;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;


public class SpamDetectorTest {

  @Test
  public void testAvgSimilarityCalculation() {

    Email email = new Email("hello world", "");
    Email spam1 = new Email("world", "");
    Email spam2 = new Email("hello world", "");

    List<Email> emails = Arrays.asList(spam1, spam2);

    double actual = SpamDetector.getSimilarity(email, emails);

    double expected = 0.75;

    assertEquals(expected, actual, 0.001);

  }

}