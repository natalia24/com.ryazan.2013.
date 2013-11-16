package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserContext implements Serializable {

    private boolean authorized = false;
    private TokenResponse token;
    private UserInfo info;

    public boolean isAuthorized() {
        return authorized;
    }

    public TokenResponse getToken() {
        return token;
    }

    public void setToken(TokenResponse token) {
        this.token = token;
        if (token != null) {
            this.authorized = true;
            this.info = new UserInfo();
            this.info.setName(token.getAdditionalInformation().getUserBean().getFullname());
        }
    }

    public UserInfo getInfo() {
        return info;
    }
}
