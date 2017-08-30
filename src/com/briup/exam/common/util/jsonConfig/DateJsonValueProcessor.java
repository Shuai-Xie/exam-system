package com.briup.exam.common.util.jsonConfig;

import java.text.SimpleDateFormat;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateJsonValueProcessor implements JsonValueProcessor {

    public Object processArrayValue(Object arg0, JsonConfig arg1) {
        return null;
    }

    public Object processObjectValue(String arg0, Object obj, JsonConfig arg2) {
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
        if (obj == null) {
            return "";
        } else {
            return dateFmt.format(obj);
        }
    }

}
