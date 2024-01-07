package com.qa.config.converters;

import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class StringToURLConverter implements Converter<URL> {
    @Override
    @SneakyThrows
    public URL convert(Method method, String stringUrl) {
            return new URL(stringUrl);
    }
}
