package com.spamdetector.dao;

import com.spamdetector.Email;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileEmailDao implements EmailDao{

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