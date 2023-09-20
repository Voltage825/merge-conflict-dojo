package com.example.patterns.unitofwork.sample;

import lombok.Getter;

@Getter
public enum UnitActions {
  INSERT("INSERT"), MODIFY("MODIFY"), DELETE("DELETE");

  private final String actionValue;

  UnitActions(String actionValue) {
    this.actionValue = actionValue;
  }
}
