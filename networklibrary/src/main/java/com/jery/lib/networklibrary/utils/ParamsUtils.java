package com.jery.lib.networklibrary.utils;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class ParamsUtils {
    public static boolean hasValue(Object data) {
        if (data instanceof String)
            return !(TextUtils.isEmpty((String) data) || data.equals("null"));
        else
            return false;
    }

    public static HashMap<String, Object> checkedParams(HashMap<String, Object> params) {
        HashMap<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() instanceof String) {
                if (hasValue(entry.getValue()))
                    result.put(entry.getKey(), entry.getValue());
            } else if (entry.getValue() != null) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
