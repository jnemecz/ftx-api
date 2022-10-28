package com.akalea.ftx.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jirka on 28.10.2022.
 *
 * @author Jiri Nemec
 */
public class CanceOrderResponse {

  @JsonProperty("success")
  private boolean success;

  @JsonProperty("result")
  private String result;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

}
