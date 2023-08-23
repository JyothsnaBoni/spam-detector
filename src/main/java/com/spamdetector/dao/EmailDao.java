package com.spamdetector.dao;

import com.spamdetector.Email;
import java.io.IOException;
import java.util.List;

public interface EmailDao {

  List<Email> loadEmails() throws IOException;

}