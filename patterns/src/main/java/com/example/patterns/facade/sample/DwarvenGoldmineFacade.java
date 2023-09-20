package com.example.patterns.facade.sample;

import java.util.Collection;
import java.util.List;

public class DwarvenGoldmineFacade {

  private final List<DwarvenMineWorker> workers;

  public DwarvenGoldmineFacade() {
    workers = List.of(new DwarvenGoldDigger(), new DwarvenCartOperator(), new DwarvenTunnelDigger());
  }

  public void startNewDay() {
    makeActions(workers, Action.WAKE_UP, Action.GO_TO_MINE);
  }

  public void digOutGold() {
    makeActions(workers, Action.WORK);
  }

  public void endDay() {
    makeActions(workers, Action.GO_HOME, Action.GO_TO_SLEEP);
  }

  private static void makeActions(Collection<DwarvenMineWorker> workers, Action... actions) {
    workers.forEach(worker -> worker.action(actions));
  }
}
