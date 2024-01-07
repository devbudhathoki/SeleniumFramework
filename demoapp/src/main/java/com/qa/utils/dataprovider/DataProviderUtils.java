package com.qa.utils.dataprovider;

import com.qa.constants.FrameworkConstants;
import com.qa.utils.excel.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
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

        sublist.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));


        // Convert List<Map<String, Object>> to Object[][]
        Object[][] result = new Object[sublist.size()][1];
        for (int i = 0; i < sublist.size(); i++) {
            result[i][0] = sublist.get(i);
        }
        return result;

    }


}
