package org.bandhu.ext.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.bandhu.ext.util.KeyValue;

public class ParamExtention implements Serializable {
    private final Map<Integer, KeyValue<String, String>> params = new HashMap<Integer, KeyValue<String, String>>();

    public ParamExtention addParam(KeyValue<Integer, String> id, String value) {
        params.put(id.getKey(), new KeyValue<String, String>(id.getValue(),
                value));
        return this;
    }

    public ParamExtention addParam(KeyValue<Integer, String> id, Integer value) {
        params.put(id.getKey(), new KeyValue<String, String>(id.getValue(),
                String.valueOf(value)));
        return this;
    }

    public KeyValue<String, String> getParam(String key) {
        return params.get(key);
    }

    public Map<Integer, KeyValue<String, String>> getParams() {
        return params;
    }

}
