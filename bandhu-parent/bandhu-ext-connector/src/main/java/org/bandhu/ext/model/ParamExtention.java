package org.bandhu.ext.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    public static class KeyValue<L, N> implements Serializable {
        private L key;
        private N value;

        public KeyValue(L key, N value) {
            this.key = key;
            this.value = value;
        }

        public L getKey() {
            return key;
        }

        public N getValue() {
            return value;
        }
    }

}
