package org.bandhu.ext.wp.bean;

import java.util.HashMap;
import java.util.Map;

import org.bandhu.core.rpc.annotation.BandhuParser;

public class Test {
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        map.put("blogName", "jasphior");
        map.put("url", "http://jasphior.wordpress.com/");
        Object parse = BandhuParser.parse(Blog.class, map);
        System.out.println(parse);
    }
}
