package com.qa.config.converters;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.aeonbits.owner.Converter;

import com.qa.enums.BrowserType;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {

    @Override
    public BrowserType convert(Method method, String browserName) {
        Map<String, BrowserType> stringBrowserTypeMap = Map.of("CHROME", BrowserType.CHROME, "FIREFOX",
                BrowserType.FIREFOX, "UNKNOWN", BrowserType.UNKNOWN);
        return stringBrowserTypeMap.getOrDefault(browserName.toUpperCase(), BrowserType.UNKNOWN);
    }

}
