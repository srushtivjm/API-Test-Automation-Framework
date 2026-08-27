package utils;

import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonReader {

    public static String readJsonFile(String filePath) throws IOException{
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static Object[][] readTestData(String filePath) throws IOException{

        String json = readJsonFile(filePath);

        List<Map<String, Object>> data =
                JsonPath.from(json).getList("");


        Object[][] testData = new Object[data.size()][3];

        for(int i = 0; i < data.size(); i++){

            testData[i][0] = data.get(i).get("title");
            testData[i][1] = data.get(i).get("body");
            testData[i][2] = data.get(i).get("userId");

        }
        return testData;
    }
}
