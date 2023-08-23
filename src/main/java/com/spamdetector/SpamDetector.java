package com.spamdetector;

import com.spamdetector.dao.EmailDao;
import com.spamdetector.dao.FileEmailDao;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class SpamDetector 
{
    public static void main( String[] args ) throws IOException
    {

        EmailDao dao = new FileEmailDao();
        List<Email> emails = dao.loadEmails();

        
        for(Email email : emails) {

            double avgSimilarity = calculateSimilarity(email, emails);
    
            email.setSpamProbability(avgSimilarity);
  
        }

        for(Email email : emails) {

            System.out.println(email.getSubject() + " spam probability: " 
                + email.getSpamProbability());
          
          }
    }


  private static double calculateSimilarity(Email email, List<Email> emails) {

    double sum = 0;

    for(Email other : emails) {
        sum += new EmailSimilarityDetector()
            .checkSimilarity(email, other);
    }

    return sum/emails.size();

    }

    public static double getSimilarity(Email email, List<Email> emails) {
        return calculateSimilarity(email, emails);
    }
}