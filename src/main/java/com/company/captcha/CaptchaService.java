package com.company.captcha;

import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import static java.util.Objects.isNull;

@Service("captchaService")
public class CaptchaService {
    CaptchaSettings captchaSettings;

    public CaptchaService(CaptchaSettings captchaSettings) {
        this.captchaSettings = captchaSettings;
    }

    public boolean verify(String gRecaptchaResponse) {
        if (isNull(gRecaptchaResponse) || gRecaptchaResponse.length() == 0) {
            return false;
        }
        try {
            URL verifyUrl = new URL(captchaSettings.getSiteVerifyUrl());
            HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            String postParams = "secret=" + captchaSettings.getSecretV2() + "&response=" + gRecaptchaResponse;
            conn.setDoOutput(true);
            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());
            outStream.flush();
            outStream.close();
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode=" + responseCode);
            InputStream is = conn.getInputStream();
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            boolean success = jsonObject.getBoolean("success");
            return success;
        } catch (Exception e) {
            return false;
        }
    }
}
