package org.bandhu.ext.gdata.blogger;

import org.bandhu.core.Consumer;
import org.bandhu.core.ServiceAccessor;
import org.bandhu.util.BandhuException;

import com.google.gdata.client.GoogleService;
import com.google.gdata.client.blogger.BloggerService;
import com.google.gdata.data.Entry;

public class BloggerAccessor extends ServiceAccessor {
    public static String METAFEEDURL = "http://www.blogger.com/feeds/default/blogs";
    public static String CATEGORY_NS_URL = "http://www.blogger.com/atom/ns#";

    private BloggerService service;
    private Entry blog;

    public BloggerAccessor(BloggerService service, Entry blog, Consumer consumer)
            throws BandhuException {
        super(consumer);
        this.service = service;
        this.blog = blog;
    }

    public GoogleService getService() {
        return service;
    }

    public Entry getBlog() {
        return blog;
    }
}
