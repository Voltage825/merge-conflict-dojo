package com.example.patterns.unitofwork.sample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeaponDatabase {

  public void insert(Weapon weapon) {
    log.info("INSERT Weapon into DB -> {}", weapon);
  }

  public void modify(Weapon weapon) {
    log.info("UPDATE Weapon on the DB -> {}", weapon);
  }

  public void delete(Weapon weapon) {
    log.info("DELETE Weapon from DB -> {}", weapon);
  }
}
