package util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtil {

    public static <T> T fromJson(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }

    public static <T> T fromJson(String json, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    public static <T> String toJson(T obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static JsonObject parse(String json) {
        return JsonParser.parseString(json).getAsJsonObject();
    }

    public static String getValue(JsonObject object, String key) throws NumberFormatException, IndexOutOfBoundsException {
        List<String> keyChain = getKeyChain(key);
        //JsonElement currentObj = object.deepCopy();
        JsonElement elem = object.deepCopy();
        for (String singleKey : keyChain) {
            if (singleKey.matches("\\[.*]$")) {
                int len = singleKey.length();
                int index = Integer.parseInt(singleKey.substring(1, len - 1));
                elem = elem.getAsJsonArray().get(index);
            } else {
                elem = elem.getAsJsonObject().get(singleKey);
                if (elem == null || elem.isJsonNull()) return null;
                if (elem.isJsonPrimitive()) return elem.getAsJsonPrimitive().getAsString();
                if (elem.isJsonArray()) {
                    elem = elem.getAsJsonArray();
                } else {
                    elem = elem.getAsJsonObject();
                }
            }
        }
        return elem.toString();
    }

    public static String getValue(String jsonStr, String key) {
        return getValue(parse(jsonStr), key);
    }
    public static int getValueAsInteger(String jsonStr, String key) {
        return Integer.parseInt(getValue(jsonStr, key));
    }
    public static int getValueAsInteger(JsonObject jsonObj, String key) {
        return Integer.parseInt(getValue(jsonObj, key));
    }
    public static long getValueAsLong(String jsonStr, String key) {
        return Long.parseLong(getValue(jsonStr, key));
    }
    public static long getValueAsLong(JsonObject jsonObj, String key) {
        return Long.parseLong(getValue(jsonObj, key));
    }
    public static double getValueAsDouble(JsonObject jsonObj, String key) {
        return Double.parseDouble(getValue(jsonObj, key));
    }
    public static double getValueAsDouble(String jsonStr, String key) {
        return Double.parseDouble(getValue(jsonStr, key));
    }
    public static float getValueAsFloat(JsonObject jsonObj, String key) {
        return Float.parseFloat(getValue(jsonObj, key));
    }
    public static float getValueAsFloat(String jsonStr, String key) {
        return Float.parseFloat(getValue(jsonStr, key));
    }
    public static boolean getValueAsBoolean(String jsonStr, String key) {
        return Boolean.parseBoolean(getValue(jsonStr, key));
    }
    public static boolean getValueAsBoolean(JsonObject jsonObj, String key) {
        return Boolean.parseBoolean(getValue(jsonObj, key));
    }
    public static boolean contain(String jsonStr, String key) {
        return (getValue(jsonStr, key) != null);
    }

    public static boolean contain(JsonObject jsonObj, String key) {
        return (getValue(jsonObj, key) != null);
    }

    private static List<String> getKeyChain(String key) {
        String[] splitKey = key.split("[.\\[]");
        List<String> keys = new ArrayList<>();
        for (String singleKey : splitKey) {
            if (singleKey.matches(".*]$")) {
                keys.add("[" + singleKey);
            } else {
                keys.add(singleKey);
            }
        }
        return keys;
    }
}