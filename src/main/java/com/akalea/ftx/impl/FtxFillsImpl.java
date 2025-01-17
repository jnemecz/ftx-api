package com.akalea.ftx.impl;

import com.akalea.ftx.FtxApi;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxFill;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class FtxFillsImpl extends FtxApiBase implements FtxApi.Fills {

  @Override
  public List<FtxFill> getFills(String market, FtxCredentials auth) {
    return getFills(market, Optional.empty(), Optional.empty(), auth);
  }

  @Override
  public List<FtxFill> getFills(String market, Optional<LocalDateTime> startTime, Optional<LocalDateTime> endTime, FtxCredentials auth) {

    final HashMap<String, String> params = new HashMap<>();

    if (market != null) {
      params.put("market", market);
    }

    startTime.ifPresent(localDateTime -> params.put("start_time", String.valueOf(getEpoch(localDateTime))));
    endTime.ifPresent(localDateTime -> params.put("end_time", String.valueOf(getEpoch(localDateTime))));

    String url = url(String.format("api/fills?%s", paramsToUrl(params)));

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
