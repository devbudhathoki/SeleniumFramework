package com.qa.config.converters;

import com.qa.enums.Retry;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToRetryModeConverter implements Converter<Retry> {
    @Override
    public Retry convert(Method method, String retrymode) {

        Map<String, Retry> map = Map.of("YES",Retry.YES, "NO",Retry.NO);
        return map.getOrDefault(retrymode.toUpperCase(),Retry.NO);
    }
}
