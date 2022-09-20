package com.akalea.ftx.impl;

import com.akalea.ftx.FtxApi;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxFill;
import com.akalea.ftx.domain.FtxOrder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FtxFillsImpl extends FtxApiBase implements FtxApi.Fills {

  @Override
  public List<FtxFill> getFills(String market, FtxCredentials auth) {

    String url = url(String.format("api/fills?market=%s", market));

    ResponseEntity<FtxFillsImpl.FtxFillsResponse> resp = restTemplate.exchange(
        url,
        HttpMethod.GET,
        signedRequest(url, HttpMethod.GET, null, auth),
        FtxFillsImpl.FtxFillsResponse.class
    );

    return resp
        .getBody()
        .getResult();
  }

  private static class FtxFillsResponse extends FtxResponse<List<FtxFill>> {

  }

}
