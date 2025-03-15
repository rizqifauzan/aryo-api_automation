package utilities;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class utilities {

    public static <T> T readTestData(String filePath, Class<T> clazz) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, clazz);
        }
    }
}