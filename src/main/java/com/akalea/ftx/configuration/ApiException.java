package com.akalea.ftx.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Created by jirka on 28.10.2022.
 *
 * @author Jiri Nemec
 */
public class ApiException extends RuntimeException {

  private final HttpStatus statusCode;
  private final ClientHttpResponse response;
  private final String message;

  public ApiException(HttpStatus statusCode, String message, ClientHttpResponse response) {
    this.statusCode= statusCode;
    this.message = message;
    this.response = response;
  }

  public HttpStatus getStatusCode() {
    return statusCode;
  }

  public ClientHttpResponse getResponse() {
    return response;
  }

  @Override
  public String getMessage() {
    return message;
  }

}
