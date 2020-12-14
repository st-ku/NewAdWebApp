package com.company.captcha;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix = "captcha")
public class CaptchaSettings {
    private String siteV2;
    private String secretV2;
    private String siteVerifyUrl;

    public String getSiteVerifyUrl() {
        return siteVerifyUrl;
    }

    public void setSiteVerifyUrl(String siteVerifyUrl) {
        this.siteVerifyUrl = siteVerifyUrl;
    }

    public String getSiteV2() {
        return siteV2;
    }

    public void setSiteV2(String siteV2) {
        this.siteV2 = siteV2;
    }

    public String getSecretV2() {
        return secretV2;
    }

    public void setSecretV2(String secretV2) {
        this.secretV2 = secretV2;
    }
}
