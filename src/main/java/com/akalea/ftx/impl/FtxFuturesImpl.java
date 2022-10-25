package com.akalea.ftx.impl;

import com.akalea.ftx.FtxApi;
import com.akalea.ftx.domain.FtxFuture;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FtxFuturesImpl extends FtxApiBase implements FtxApi.Futures {

  @Override
  public FtxFuture getFuture(String market) {

    String url = url(String.format("api/futures/%s", market));

    ResponseEntity<FtxFuturesImpl.FtxFutureResponse> resp =
        restTemplate.exchange(
            url,
            HttpMethod.GET,
            signedRequest(url, HttpMethod.GET, null),
            new ParameterizedTypeReference<FtxFuturesImpl.FtxFutureResponse>() {

            });
    return resp
        .getBody()
        .getResult();

  }

  @Override
  public List<FtxFuture> getFutures() {

    String url = "api/futures";

    ResponseEntity<FtxFuturesImpl.FtxFuturesResponse> resp = restTemplate.exchange(
        url,
        HttpMethod.GET,
        signedRequest(url, HttpMethod.GET, null, null),
        FtxFuturesImpl.FtxFuturesResponse.class
    );

    return resp
        .getBody()
        .getResult();

  }

  private static class FtxFuturesResponse extends FtxResponse<List<FtxFuture>> {

  }

  private static class FtxFutureResponse extends FtxResponse<FtxFuture> {

  }

}
