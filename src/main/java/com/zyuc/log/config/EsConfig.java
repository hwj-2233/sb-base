package com.zyuc.log.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongwj
 * @date 2021/01/07
 **/
@Configuration
public class EsConfig {

    @Value("${com.waner.es.host}")
    private String host;

    @Value("${com.waner.es.port}")
    private int port;

    @Value("${com.waner.es.protocol}")
    private String protocol;

    @Bean
    public RestHighLevelClient getRestHighLevelClientPre() {
        return new RestHighLevelClient(RestClient
                .builder(new HttpHost(host, port, protocol)));
    }

}
