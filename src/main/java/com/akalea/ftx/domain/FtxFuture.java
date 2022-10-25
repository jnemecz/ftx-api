package com.akalea.ftx.domain;

public class FtxFuture {

  private String name;
  private String underlying;
  private String description;

  private boolean enabled;
  private boolean expired;

  private double last;
  private double mark;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnderlying() {
    return underlying;
  }

  public void setUnderlying(String underlying) {
    this.underlying = underlying;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isExpired() {
    return expired;
  }

  public void setExpired(boolean expired) {
    this.expired = expired;
  }

  public double getLast() {
    return last;
  }

  public void setLast(double last) {
    this.last = last;
  }

  public double getMark() {
    return mark;
  }

  public void setMark(double mark) {
    this.mark = mark;
  }
}
