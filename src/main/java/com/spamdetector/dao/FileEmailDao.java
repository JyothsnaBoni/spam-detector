package com.spamdetector.dao;

import com.spamdetector.Email;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**

  Data access object implementation for loading emails from a file.
*/

public class FileEmailDao implements EmailDao{

  /**

    Parses email data from a text file and returns list of Email objects.
    File format is one email per line with subject,body separated by comma.
    @return List of Email objects populated from file data
    @throws IOException if file can't be read
  */

  @Override
  public List<Email> loadEmails() throws IOException {
    return Files.lines(Paths.get("src/main/resources/emails.txt"))
      .map(line -> {
        String[] parts = line.split(",");
        return new Email(parts[0], parts[1]);
      })
      .collect(Collectors.toList());
  }

}