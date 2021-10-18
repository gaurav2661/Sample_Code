package springframework.brewery.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private final Integer MaxTotal;
    private final Integer DefaultMxPerRoute;
    private final Integer ConnectionRequestTimeout;
    private final Integer SocketTimeout;

    public BlockingRestTemplateCustomizer(@Value("${MAXTOTAL}") Integer maxTotal,
                                         @Value("${DEFAULTMAXPERROUTE}") Integer defaultMxPerRoute,
                                          @Value("${CONNECTIONREQUESTTIMEOUT}") Integer connectionRequestTimeout,
                                          @Value("${SOCKETIMEOUT}") Integer socketTimeout) {
        MaxTotal = maxTotal;
        DefaultMxPerRoute = defaultMxPerRoute;
        ConnectionRequestTimeout = connectionRequestTimeout;
        SocketTimeout = socketTimeout;
    }

    public ClientHttpRequestFactory clientHttpRequestFactory(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MaxTotal);
        connectionManager.setDefaultMaxPerRoute(DefaultMxPerRoute);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(ConnectionRequestTimeout)
                .setSocketTimeout(SocketTimeout)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
