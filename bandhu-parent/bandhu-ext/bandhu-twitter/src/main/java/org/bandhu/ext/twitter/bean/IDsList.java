package org.bandhu.ext.twitter.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import twitter4j.IDs;

public class IDsList<E> extends ArrayList<E> {
    private IDs ids;
    private Map<Long, E> map;

    public IDsList(IDs ids) {
        super(ids.getIDs().length);
        map = new HashMap<Long, E>(ids.getIDs().length);
        this.ids = ids;
    }

    public IDs getIDs() {
        return ids;
    }

    public boolean add(long id, E e) {
        map.put(id, e);
        return super.add(e);
    }

}
