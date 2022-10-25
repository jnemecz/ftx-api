package com.akalea.ftx.impl;

import com.akalea.ftx.FtxApi.Markets;
import com.akalea.ftx.domain.FtxMarket;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FtxMarketsImpl extends FtxApiBase implements Markets {

  public List<FtxMarket> getMarkets() {
    String url = url("api/markets");

    ResponseEntity<FtxMarketsResponse> resp = restTemplate
        .exchange(
            url,
            HttpMethod.GET,
            signedRequest(url, HttpMethod.GET, null),
            new ParameterizedTypeReference<FtxMarketsResponse>() {
            });

    return resp
        .getBody()
        .getResult();
  }

  public FtxMarket getMarket(String market) {
    String url = url(String.format("api/markets/%s", market));
    ResponseEntity<FtxMarketResponse> resp =
        restTemplate.exchange(
            url,
            HttpMethod.GET,
            signedRequest(url, HttpMethod.GET, null),
            new ParameterizedTypeReference<FtxMarketResponse>() {
            });
    return resp
        .getBody()
        .getResult();
  }

  private static class FtxMarketsResponse extends FtxResponse<List<FtxMarket>> {

  }

  private static class FtxMarketResponse extends FtxResponse<FtxMarket> {

  }

}
