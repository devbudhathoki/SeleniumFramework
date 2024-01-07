package com.qa.config.converters;

import com.qa.enums.RUNMODE;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToRunModeConverter implements Converter {

    @Override
    public Object convert(Method method, String runModeString) {
        Map<String, RUNMODE> runModeMap= Map.of("LOCAL",RUNMODE.LOCAL,"REMOTE",RUNMODE.REMOTE);
        return runModeMap.getOrDefault(runModeString.toUpperCase(), RUNMODE.LOCAL);
    }
}
