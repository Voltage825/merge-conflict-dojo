package com.example.patterns.facade;

import com.example.patterns.facade.sample.DwarvenGoldmineFacade;

public class Main {

  public static void main(String[] args) {
    var facade = new DwarvenGoldmineFacade();

    facade.startNewDay();
    facade.digOutGold();
    facade.endDay();

  }
}
