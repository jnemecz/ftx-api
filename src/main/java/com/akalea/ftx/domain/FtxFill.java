package com.akalea.ftx.domain;

import java.util.Date;

public class FtxFill {

  private Long id;
  private Long orderId;
  private Long tradeId;
  private Double price;
  private Double size;
  private Double fee;
  private Double feeRate;
  private String feeCurrency;
  private String liquidity;
  private String side;
  private String type;
  private String market;
  private String future;
  private Date time;

  public FtxFill setId(Long id) {
    this.id = id;
    return this;
  }

  public FtxFill setOrderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  public FtxFill setTradeId(Long tradeId) {
    this.tradeId = tradeId;
    return this;
  }

  public FtxFill setPrice(Double price) {
    this.price = price;
    return this;
  }

  public FtxFill setSize(Double size) {
    this.size = size;
    return this;
  }

  public FtxFill setFee(Double fee) {
    this.fee = fee;
    return this;
  }

  public FtxFill setFeeRate(Double feeRate) {
    this.feeRate = feeRate;
    return this;
  }

  public FtxFill setFeeCurrency(String feeCurrency) {
    this.feeCurrency = feeCurrency;
    return this;
  }

  public FtxFill setLiquidity(String liquidity) {
    this.liquidity = liquidity;
    return this;
  }

  public FtxFill setSide(String side) {
    this.side = side;
    return this;
  }

  public FtxFill setType(String type) {
    this.type = type;
    return this;
  }

  public FtxFill setMarket(String market) {
    this.market = market;
    return this;
  }

  public FtxFill setFuture(String future) {
    this.future = future;
    return this;
  }

  public FtxFill setTime(Date time) {
    this.time = time;
    return this;
  }

  public Long getId() {
    return id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public Long getTradeId() {
    return tradeId;
  }

  public Double getPrice() {
    return price;
  }

  public Double getSize() {
    return size;
  }

  public Double getFee() {
    return fee;
  }

  public Double getFeeRate() {
    return feeRate;
  }

  public String getFeeCurrency() {
    return feeCurrency;
  }

  public String getLiquidity() {
    return liquidity;
  }

  public String getSide() {
    return side;
  }

  public String getType() {
    return type;
  }

  public String getMarket() {
    return market;
  }

  public String getFuture() {
    return future;
  }

  public Date getTime() {
    return time;
  }
}
