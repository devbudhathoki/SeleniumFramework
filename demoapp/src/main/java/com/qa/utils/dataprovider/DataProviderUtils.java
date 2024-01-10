package com.qa.utils.dataprovider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.constants.FrameworkConstants;
import com.qa.utils.excel.ExcelUtils;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class DataProviderUtils {

    private DataProviderUtils() {}

    private static List<Map<String, String>> list =	new ArrayList<>();

    @DataProvider(parallel=true)
    public static Object[][] getData(Method m) {
        String testName = m.getName();

        if(list.isEmpty()) {
            list = ExcelUtils.importTestData(FrameworkConstants.getDataSheet());
        }

        List<Map<String, String>> sublist = new ArrayList<>(list);

        Predicate<Map<String,String>> isTestNameNotMatching = map ->!map.get("testname").equalsIgnoreCase(testName);
        Predicate<Map<String,String>> isExecuteColumnNo = map -> map.get("execute").equalsIgnoreCase("no");
        Predicate<Map<String,String>> isEmptyTest = map -> map.get("testname").isEmpty();

        sublist.removeIf(isTestNameNotMatching.or(isExecuteColumnNo).or(isEmptyTest));


        // Convert List<Map<String, Object>> to Object[][]
        Object[][] result = new Object[sublist.size()][1];
        for (int i = 0; i < sublist.size(); i++) {
            result[i][0] = sublist.get(i);
        }
        return result;

    }

    @SneakyThrows
    @DataProvider
    public static Object[][] getDataFromJson(){

        HashMap<String, String> map1 = new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/json/config.json"),
                        new TypeReference<HashMap<String, String>>(){});

        List list = new ArrayList(map1.size());
        list.add(map1);

        Object[][] result = new Object[list.size()][1];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i);
        }
        return  result;

    }


}
