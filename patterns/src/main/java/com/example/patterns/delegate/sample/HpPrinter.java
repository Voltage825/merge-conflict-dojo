package com.example.patterns.delegate.sample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HpPrinter implements Printer {

  @Override
  public void print(String message) {
    log.info("Fetch a paper...");
    log.info("Connect to the internet...");
    log.info("Check cartridge is authentic using online service...");
    log.info("Checking if we are printing US currency...");
    log.info("Let the CIA know what you are printing using online service...");
    log.info("HP Printer : {}", message);
  }
}
