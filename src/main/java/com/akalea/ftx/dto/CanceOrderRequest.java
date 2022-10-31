package com.akalea.ftx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jirka on 28.10.2022.
 *
 * @author Jiri Nemec
 */
public class CanceOrderRequest {

  @JsonProperty("market")
  private String market;

  public String getMarket() {
    return market;
  }

  public void setMarket(String market) {
    this.market = market;
  }

}
