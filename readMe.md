# Email Spam Detection

A Java based spam detection model that calculates email similarity.

Here is the updated README file with instructions on setting up and running the project:

# Email Spam Detection

A Java based spam detection model.

## Setup

1. clone the project from GitHub
1. Open project in IDE (IntelliJ/Eclipse etc)
1. Run `mvn install` to download dependencies

## Running Tests

1. In project directory run `mvn test`
1. View test reports at target/surefire-reports

## Running Application

1. A main method is provided in SpamDetector.java
1. Run SpamDetector class as Java Application
1. Use Use Maven plugin to run main class. command:
`mvn compile exec:java -Dexec.mainClass="com.spamdetector.SpamDetector"`
1. Sample emails and output will be printed

## Overview

The key components are:

- Email - Represents an email object
- EmailSimilarityDetector - Calculates similarity between emails
- SpamDetector - Uses similarities to detect spam emails
- Tests - Unit test classes

## Algorithm

EmailSimilarityDetector class implements an algorithm:

1. Splits email into arrays of individual words
1. Counts number of common words between emails
1. Calculates similarity score as ratio of common words

## Usage

1. Create Email objects with sample content
1. Call EmailSimilarityDetector.checkSimilarity()
1. Pass emails to SpamDetector.getSimilarity()

## Tests

### EmailSimilarityDetectorTest

Tests similarity calculation...

### SpamDetectorTest

Tests average similarity calculation...

Tests validate:

- Similarity returns expected values
- SpamDetector calculates average correctly

## Future Enhancements

Areas that could be improved:

1. Stemming/Lemmatization
1. Remove stop words
1. TF-IDF weighting
1. Machine learning models