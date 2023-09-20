package com.example.patterns.delegate.sample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CanonPrinter implements Printer {

  @Override
  public void print(String message) {
    log.info("Fetch a paper...");
    log.info("Take a selfie...");
    log.info("Canon Printer Printed: {}", message);
  }
}
