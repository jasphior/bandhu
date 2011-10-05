package org.bandhu.ext.util;

import java.io.Serializable;

public class KeyValue<L, N> implements Serializable {
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
