package com.akalea.ftx;

import com.akalea.ftx.domain.FtxAccount;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxFill;
import com.akalea.ftx.domain.FtxFuture;
import com.akalea.ftx.domain.FtxMarket;
import com.akalea.ftx.domain.FtxOrder;
import com.akalea.ftx.domain.FtxPosition;
import com.akalea.ftx.domain.FtxSubAccount;
import com.akalea.ftx.domain.FtxSubAccountBalance;
import com.akalea.ftx.dto.CanceOrderRequest;
import com.akalea.ftx.dto.CanceOrderResponse;
import com.akalea.ftx.impl.FtxFillsImpl;
import com.akalea.ftx.impl.FtxFuturesImpl;
import com.akalea.ftx.impl.FtxMarketsImpl;
import com.akalea.ftx.impl.FtxOrdersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FtxApi {
  @Autowired
  private Accounts accounts;

  @Autowired
  private FtxMarketsImpl markets;

  @Autowired
  private FtxOrdersImpl orders;

  @Autowired
  private FtxFillsImpl fills;

  @Autowired
  private FtxFuturesImpl futures;

  public AuthenticatedFtxApi withAuth(FtxCredentials auth) {
    return new AuthenticatedFtxApi()
        .setApi(this)
        .setAuth(auth);
  }

  public Accounts accounts() {
    return accounts;
  }

  public Fills fills() {
    return fills;
  }

  public Markets markets() {
    return markets;
  }

  public Futures futures() {
    return futures;
  }

  public Orders orders() {
    return orders;
  }

  public interface Accounts {
    FtxAccount getAccount(FtxCredentials auth);

    List<FtxSubAccount> getSubAccounts(FtxCredentials auth);

    List<FtxSubAccountBalance> getSubAccountBalances(
        String nickname,
        FtxCredentials auth);

    Double getFreeCollateral(String coin, FtxCredentials auth);

    Double getMainAccountFreeCollateral(String coin, FtxCredentials auth);

    Double getSubAccountFreeCollateral(
        String nickname,
        String coin,
        FtxCredentials auth);

    List<FtxPosition> getPositions(FtxCredentials auth);

    List<FtxPosition> getPositions(String market, FtxCredentials auth);
  }

  public interface AccountsAuth {
    FtxAccount getAccount();

    List<FtxSubAccount> getSubAccounts();

    List<FtxSubAccountBalance> getSubAccountBalances(String nickname);

    Double getFreeCollateral(String coin);

    Double getMainAccountFreeCollateral(String coin);

    Double getSubAccountFreeCollateral(String nickname, String coin);

    List<FtxPosition> getPositions();

    List<FtxPosition> getPositions(String market);
  }

  public interface Fills {
    List<FtxFill> getFills(String market, FtxCredentials auth);

    List<FtxFill> getFills(String market,
                           Optional<LocalDateTime> startTime,
                           Optional<LocalDateTime> endTime,
                           FtxCredentials auth
    );
  }

  public interface Orders {

    FtxOrder placeOrder(FtxOrder order, FtxCredentials auth);

    CanceOrderResponse cancelOrder(CanceOrderRequest request, String clientId, FtxCredentials auth);

    FtxOrder modifyOrder(FtxOrder order,FtxCredentials auth);

    List<FtxOrder> getOrders(String market, FtxCredentials auth);

    FtxOrder getOrder(String clientId, FtxCredentials auth);

  }

  public interface OrdersAuth {
    FtxOrder placeOrder(FtxOrder order);

    List<FtxOrder> getOrders(String market);
  }

  public interface Markets {
    List<FtxMarket> getMarkets();

    FtxMarket getMarket(String market);
  }

  public interface Futures {

    List<FtxFuture> getFutures();

    FtxFuture getFuture(String future);

  }

  public static class AuthenticatedFtxApi {
    private FtxApi api;
    private FtxCredentials auth;

    public AccountsAuth accounts() {
      return new AccountsAuth() {

        @Override
        public FtxAccount getAccount() {
          return api.accounts.getAccount(auth);
        }

        @Override
        public List<FtxSubAccount> getSubAccounts() {
          return api.accounts.getSubAccounts(auth);
        }

        @Override
        public List<FtxSubAccountBalance> getSubAccountBalances(
            String nickname) {
          return api.accounts.getSubAccountBalances(nickname, auth);
        }

        @Override
        public Double getFreeCollateral(String coin) {
          return api.accounts.getFreeCollateral(coin, auth);
        }

        @Override
        public Double getMainAccountFreeCollateral(String coin) {
          return api.accounts
              .getMainAccountFreeCollateral(coin, auth);
        }

        @Override
        public Double getSubAccountFreeCollateral(
            String nickname,
            String coin) {
          return api.accounts
              .getSubAccountFreeCollateral(nickname, coin, auth);
        }

        @Override
        public List<FtxPosition> getPositions() {
          return api.accounts.getPositions(auth);
        }

        @Override
        public List<FtxPosition> getPositions(String market) {
          return api.accounts.getPositions(market, auth);
        }

      };
    }

    public OrdersAuth orders() {
      return new OrdersAuth() {



        @Override
        public FtxOrder placeOrder(FtxOrder order) {
          return api.orders.placeOrder(order, auth);
        }

        @Override
        public List<FtxOrder> getOrders(String market) {
          return api.orders.getOrders(market, auth);
        }

      };
    }

    public FtxApi getApi() {
      return api;
    }

    public AuthenticatedFtxApi setApi(FtxApi api) {
      this.api = api;
      return this;
    }

    public FtxCredentials getAuth() {
      return auth;
    }

    public AuthenticatedFtxApi setAuth(FtxCredentials auth) {
      this.auth = auth;
      return this;
    }

  }

}
