package org.bandhu.ext.gdata.picasa;

import org.bandhu.core.Consumer;
import org.bandhu.core.ServiceAccessor;
import org.bandhu.util.BandhuException;

import com.google.gdata.client.photos.PicasawebService;

public class PicasaAccessor extends ServiceAccessor {
    public static String CATEGORY_NS_URL = "http://www.blogger.com/atom/ns#";

    private PicasawebService service;
    private String metafeedUrl = "https://picasaweb.google.com/data/feed/api/user/username?kind=album";

    public PicasaAccessor(PicasawebService service, Consumer consumer)
            throws BandhuException {
        super(consumer);
        this.metafeedUrl = metafeedUrl
                .replace("username", consumer.getUserId());
        this.service = service;
    }

    public PicasawebService getService() {
        return service;
    }

    public String getMetafeedURL() {
        return metafeedUrl;
    }
}
