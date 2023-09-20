package com.example.patterns.delegate;

import com.example.patterns.delegate.sample.CanonPrinter;
import com.example.patterns.delegate.sample.EpsonPrinter;
import com.example.patterns.delegate.sample.HpPrinter;
import com.example.patterns.delegate.sample.PrinterController;

public class Main {

  private static final String MESSAGE_TO_PRINT = "hello world";

  public static void main(String[] args) {

    var hpPrinterController = new PrinterController(new HpPrinter());
    var canonPrinterController = new PrinterController(new CanonPrinter());
    var epsonPrinterController = new PrinterController(new EpsonPrinter());

    canonPrinterController.print(MESSAGE_TO_PRINT);
    epsonPrinterController.print(MESSAGE_TO_PRINT);
    hpPrinterController.print(MESSAGE_TO_PRINT);
  }
}
