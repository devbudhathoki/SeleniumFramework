package com.qa.utils;

import org.apache.hc.client5.http.utils.Base64;

import java.nio.charset.StandardCharsets;

public class DecodeUtils {

    private DecodeUtils(){}

    public static String getBase64DecodedString(String encodedString){
        return new String(Base64.decodeBase64(encodedString.getBytes(StandardCharsets.UTF_8)));
    }
}
