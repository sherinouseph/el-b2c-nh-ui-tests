package com.englishtown.helpers.reader;
/**
 * Created by nikol.marku on 19/08/2015.
 * http://iandjava.blogspot.in/2014/01/java-object-to-json-and-json-to-java.html
 * Gson API
     toJson()  – For Java object to JSON
     fromJson() – For JSON to Java object
 */
import com.google.gson.Gson;


public final class JsonUtils {
    private JsonUtils() {
    }
    public static <T> T getObject(final String jsonString, final Class<T> objectClass) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, objectClass);
    }
    public static String getString(final Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
