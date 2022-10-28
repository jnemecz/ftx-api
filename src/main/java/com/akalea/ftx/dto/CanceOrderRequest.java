package com.akalea.ftx.dto;

/**
 * Created by jirka on 28.10.2022.
 *
 * @author Jiri Nemec
 */
public class CanceOrderRequest {

  private int clientOrderId;
  private String market;

  public int getClientOrderId() {
    return clientOrderId;
  }

  public void setClientOrderId(int clientOrderId) {
    this.clientOrderId = clientOrderId;
  }

  public String getMarket() {
    return market;
  }

  public void setMarket(String market) {
    this.market = market;
  }
}
