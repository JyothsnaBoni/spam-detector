package com.spamdetector.dao;

import com.spamdetector.Email;
import java.io.IOException;
import java.util.List;

/**
  Interface for loading emails from a data source.
*/

public interface EmailDao {

  /**
    Loads a list of Email objects from the data source.
    @return List of Email objects
    @throws IOException if error occurs during loading
  */

  List<Email> loadEmails() throws IOException;

}