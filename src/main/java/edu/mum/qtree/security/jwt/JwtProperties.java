package edu.mum.qtree.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {

    private String secretKey = "secret";

    //validity in milliseconds
    private long validityInMs = 3600000 *24; // 24h

    public String getSecretKey() {
        return secretKey;
    }

    public long getValidityInMs() {
        return validityInMs;
    }
}