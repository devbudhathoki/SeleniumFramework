package com.qa.config;

import com.qa.config.converters.StringToRetryModeConverter;
import com.qa.config.converters.StringToRunModeConverter;
import com.qa.config.converters.StringToURLConverter;
import com.qa.enums.RUNMODE;
import com.qa.enums.Retry;
import org.aeonbits.owner.Config;

import com.qa.config.converters.StringToBrowserTypeConverter;
import com.qa.enums.BrowserType;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"

})

public interface FrameworkConfig extends Config {
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.url")
    @ConverterClass(StringToURLConverter.class)
    URL url();

    @DefaultValue("local")
    @ConverterClass(StringToRunModeConverter.class)
    @Key("run_mode")
    RUNMODE runmode();

    @DefaultValue("NO")
    @ConverterClass(StringToRetryModeConverter.class)
    @Key("retry_mode")
    Retry retrymode();

    @Key("passedstepsscreenshots")
    String passedStepsScreenshots();

    @Key("failedstepsscreenshots")
    String failedStepsScreenshots();

    @Key("overridereports")
    String overrideReports();
}
