package com.spamdetector;

import com.spamdetector.Email;
import com.spamdetector.dao.EmailDao;
import com.spamdetector.dao.FileEmailDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    /**

    Main class for detecting spam emails.
    Loads emails from a data source, calculates similarity between each email
    and others to determine spam probability.
    */
public class SpamDetector 
{
    /**

    Main entry point. Loads emails, calculates spam probability for each
    and prints output.
    @param args command line arguments
    @throws IOException if error loading emails
    */
    public static void main( String[] args ) throws IOException
    {

        EmailDao dao = new FileEmailDao();
        List<Email> emails = dao.loadEmails();

        
        for(Email email : emails) {

            List<Email> comparisonEmails = new ArrayList<>(emails);

            // Remove the current email from the emails list to avoid the distortion in result
            comparisonEmails.remove(email); 

            double avgSimilarity = calculateSimilarity(email, comparisonEmails);
    
            email.setSpamProbability(avgSimilarity);
  
        }

        for(Email email : emails) {

            System.out.println(email.getSubject() + " spam probability: " 
                + email.getSpamProbability());
          
          }
    }

    /**

    Calculates average similarity score for an email compared to others.
    @param email Email being checked
    @param comparisonEmails List of emails to compare against
    @return Average similarity score
    */
    private static double calculateSimilarity(Email email, List<Email> comparisonEmails) {

        double sum = 0;

        for(Email other : comparisonEmails) {
            sum += new EmailSimilarityDetector()
                .checkSimilarity(email, other);
        }

        return sum/comparisonEmails.size();

    }

    /**

    Alias for calculateSimilarity() method
    */
    public static double getSimilarity(Email email, List<Email> emails) {
        return calculateSimilarity(email, emails);
    }
}