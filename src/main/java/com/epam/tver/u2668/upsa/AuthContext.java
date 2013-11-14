package com.epam.tver.u2668.upsa;

import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AuthContext {

    private static final Logger LOGGER = Logger.getLogger(AuthContext.class.getName());

    @Autowired
    private UpsaRestClient upsaRestClient;

    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    private TokenResponse token;

    private void authorize() {
        LOGGER.info("requesting new token");
        this.token = upsaRestClient.getToken(clientId, clientSecret, false);
        LOGGER.info("new token " + this.token.getValue());
    }

    public TokenResponse getToken() {
        if (token == null) {
            authorize();
        }
        return token;
    }

    public void invalidate() {
        this.token = null;
    }

}
