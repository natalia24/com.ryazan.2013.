package com.epam.tver.u2668.config;

import com.epam.tver.u2668.upsa.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Arrays;

@EnableWebMvc
@ComponentScan("com.epam.tver.u2668")
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver result = new InternalResourceViewResolver();
        result.setPrefix("/WEB-INF/pages/");
        result.setSuffix(".jsp");
        return result;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestInterceptor authInterceptor) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        restTemplate.setInterceptors(Arrays.asList(authInterceptor));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestInterceptor authInterceptor() {
        return new AuthInterceptor();
    }
}
