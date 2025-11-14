package com.parrino.riccardo.sales_ms.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.beans.factory.ObjectFactory;

import feign.codec.Encoder;

@Configuration
public class FeignConfig {

    @Bean
    Encoder feignEncoder() {
        return new SpringEncoder(new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() {
                return new HttpMessageConverters(new MappingJackson2HttpMessageConverter());
            }
        });
    }

}
