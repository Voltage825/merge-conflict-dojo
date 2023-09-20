package com.example.patterns.delegate.sample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EpsonPrinter implements Printer {

  @Override
  public void print(String message) {
    log.info("Fetch a paper...");
    log.info("Draw some ink from my bottle...");
    log.info("Epson Printer : {}", message);
  }
}
