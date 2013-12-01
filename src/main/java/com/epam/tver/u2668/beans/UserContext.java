package com.epam.tver.u2668.beans;

import com.epam.tver.u2668.upsa.apibeans.TokenResponse;

import java.io.Serializable;

import org.apache.commons.lang3.Validate;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserContext implements Serializable {

    private final UserInfo info = new UserInfo();

    public void setToken(TokenResponse token) {
        Validate.notNull(token);

        this.info.setName(token.getAdditionalInformation().getUserBean().getFullname());
        this.info.setId(token.getAdditionalInformation().getUserBean().getPmcId());
    }

    public UserInfo getInfo() {
        return info;
    }
}
