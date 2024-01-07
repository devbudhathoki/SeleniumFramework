package com.qa.utils;

import com.qa.constants.FrameworkConstants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ChromeDriverVersions {

    private ChromeDriverVersions(){}

    public static String getJsonResponse(String urlString){
        StringBuilder responseContent = new StringBuilder();
        try {

            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method (GET in this example)
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response content
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            // Close the BufferedReader and connection
            reader.close();
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseContent.toString();
    }

    public static List getVersions() {
        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(getJsonResponse(FrameworkConstants.getChromeDriverURL()));
        // Access specific fields in the JSON object
        // Print the parsed values
        JSONArray versionsArray = jsonResponse.getJSONArray("versions");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < versionsArray.length(); i++) {
            JSONObject versionObject = versionsArray.getJSONObject(i);
            String version = versionObject.getString("version");
            list.add(version);
        }
        return list;

    }
}
