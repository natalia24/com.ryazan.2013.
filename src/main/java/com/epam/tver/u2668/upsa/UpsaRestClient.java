package com.epam.tver.u2668.upsa;

import com.epam.tver.u2668.upsa.apibeans.Employee;
import com.epam.tver.u2668.upsa.apibeans.Skill;
import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

// https://upsa.epam.com/workload/rest/v3/api/api.html
@Repository
public class UpsaRestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${upsaBaseURL}")
    private String baseURL;

    public TokenResponse getToken(String clientId, String clientSecret, boolean isEpamDomainLogin) {
        Validate.notNull(clientId);
        Validate.notNull(clientSecret);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + Base64.encodeBase64String((clientId + ":" + clientSecret).getBytes()));

        if (isEpamDomainLogin) {
            headers.add("Credentials-Type", "domain");
        }

        HttpEntity<String> entity = new HttpEntity<>("grant_type=client_credentials", headers);

        try {
            TokenResponse result = restTemplate.exchange(baseURL + "oauth/token", HttpMethod.POST, entity, TokenResponse.class).getBody();
            Validate.notNull(result);
            return result;
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new UnauthorizedException(ex);
            } else {
                throw ex;
            }
        }
    }

    public String getLocation(String employeeId) {
        return restTemplate.getForObject(baseURL + "v3/employees/{employeeId}/location", String.class, employeeId);
    }

    public Employee[] getEmployees(String city) {
        return restTemplate.getForObject(baseURL + "v3/employees?cities={city}&onlyActive=true", Employee[].class, city);
    }

    public Skill[] getEmployeeSkills(String employeeId) {
        return restTemplate.getForObject(baseURL + "v2/employees/{employeeId}/skills", Skill[].class, employeeId);
    }
}
