package com.example.patterns.unitofwork.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ArmsDealer implements IUnitOfWork<Weapon> {

  private final Map<String, List<Weapon>> context;
  private final WeaponDatabase weaponDatabase;

  @Override
  public void registerNew(Weapon weapon) {
    log.info("Registering {} for insert in context.", weapon.getName());
    register(weapon, UnitActions.INSERT.getActionValue());
  }

  @Override
  public void registerModified(Weapon weapon) {
    log.info("Registering {} for modify in context.", weapon.getName());
    register(weapon, UnitActions.MODIFY.getActionValue());

  }

  @Override
  public void registerDeleted(Weapon weapon) {
    log.info("Registering {} for delete in context.", weapon.getName());
    register(weapon, UnitActions.DELETE.getActionValue());
  }

  private void register(Weapon weapon, String operation) {
    var weaponsToOperate = context.get(operation);
    if (weaponsToOperate == null) {
      weaponsToOperate = new ArrayList<>();
    }
    weaponsToOperate.add(weapon);
    context.put(operation, weaponsToOperate);
  }

  /**
   * All UnitOfWork operations are batched and executed together on commit only.
   */
  @Override
  public void commit() {
    if (context == null || context.size() == 0) {
      return;
    }
    log.info("Commit started");
    if (context.containsKey(UnitActions.INSERT.getActionValue())) {
      commitInsert();
    }

    if (context.containsKey(UnitActions.MODIFY.getActionValue())) {
      commitModify();
    }
    if (context.containsKey(UnitActions.DELETE.getActionValue())) {
      commitDelete();
    }
    log.info("Commit finished.");
  }

  private void commitInsert() {
    var weaponsToBeInserted = context.get(UnitActions.INSERT.getActionValue());
    for (var weapon : weaponsToBeInserted) {
      log.info("Inserting a new weapon {} to sales rack.", weapon.getName());
      weaponDatabase.insert(weapon);
    }
  }

  private void commitModify() {
    var modifiedWeapons = context.get(UnitActions.MODIFY.getActionValue());
    for (var weapon : modifiedWeapons) {
      log.info("Scheduling {} for modification work.", weapon.getName());
      weaponDatabase.modify(weapon);
    }
  }

  private void commitDelete() {
    var deletedWeapons = context.get(UnitActions.DELETE.getActionValue());
    for (var weapon : deletedWeapons) {
      log.info("Scrapping {}.", weapon.getName());
      weaponDatabase.delete(weapon);
    }
  }
}
