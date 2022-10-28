package com.akalea.ftx.impl;

import com.akalea.ftx.FtxApi.Orders;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxOrder;
import com.akalea.ftx.dto.CanceOrderRequest;
import com.akalea.ftx.dto.CanceOrderResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FtxOrdersImpl extends FtxApiBase implements Orders {

  public FtxOrder placeOrder(FtxOrder order, FtxCredentials auth) {
    String url = url("api/orders");

    ResponseEntity<FtxOrderResponse> resp = restTemplate.exchange(
        url,
        HttpMethod.POST,
        signedRequest(url, HttpMethod.POST, order, auth),
        FtxOrderResponse.class);
    return resp
        .getBody()
        .getResult();
  }

  @Override
  public CanceOrderResponse cancelOrder(CanceOrderRequest request, FtxCredentials auth) {

    String url = url(String.format("api/orders/by_client_id/%s", request.getClientOrderId()));

    ResponseEntity<CanceOrderResponse> resp = restTemplate.exchange(
        url,
        HttpMethod.DELETE,
        signedRequest(url, HttpMethod.POST, request, auth),
        CanceOrderResponse.class
    );

    return resp.getBody();

  }

  @Override
  public FtxOrder modifyOrder(FtxOrder order, FtxCredentials auth) {

    String url = url(String.format("api/orders/%s/modify", order.getId()));

    ResponseEntity<FtxOrderResponse> resp = restTemplate.exchange(
        url,
        HttpMethod.POST,
        signedRequest(url, HttpMethod.POST, order, auth),
        FtxOrderResponse.class);

    return resp
        .getBody()
        .getResult();

  }

  public List<FtxOrder> getOrders(String market, FtxCredentials auth) {
    String url = url(String.format("api/orders?market=%s", market));

    ResponseEntity<FtxOrdersResponse> resp = restTemplate.exchange(
        url,
        HttpMethod.GET,
        signedRequest(url, HttpMethod.GET, null, auth),
        FtxOrdersResponse.class);
    return resp
        .getBody()
        .getResult();
  }

  private static class FtxOrderCancelResponse extends FtxResponse<FtxOrder> {

  }

  private static class FtxOrderResponse extends FtxResponse<FtxOrder> {

  }

  private static class FtxOrdersResponse extends FtxResponse<List<FtxOrder>> {

  }
}
