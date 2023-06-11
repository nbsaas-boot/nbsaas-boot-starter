package com.nbsaas.boot.user.ext.handler;

import com.google.gson.JsonElement;

public class ElementUtils {

  public static String getString(JsonElement element, String key) {

    String result = "";
    try {
      result = element.getAsJsonObject().get(key).getAsString();
    } catch (Exception e2) {
    }

    return result;
  }

  public static Integer getInt(JsonElement element, String key) {

    Integer result = 0;
    try {
      result = element.getAsJsonObject().get(key).getAsInt();
    } catch (Exception e2) {
    }
    return result;
  }

}
