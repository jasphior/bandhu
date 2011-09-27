package org.bandhu.ext.wp;

import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.bandhu.core.Consumer;
import org.bandhu.core.rpc.RPCService;
import org.bandhu.util.BandhuException;

public class WordPressAccessor extends RPCService {
    private String blogURL;
    private int blogId;
    private XmlRpcClient client;

    public WordPressAccessor(String blogName, int blogId, Consumer consumer)
            throws BandhuException {
        super(consumer);
        this.blogURL = "https://" + blogName + ".wordpress.com/xmlrpc.php";
        this.blogId = blogId;
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL(blogURL));
            client = new XmlRpcClient();
            client.setConfig(config);
        } catch (Exception e) {
            throw new BandhuException("Unable to service client!");
        }
    }

    public String getBlogURL() {
        return blogURL;
    }

    public int getBlogId() {
        return blogId;
    }

    public XmlRpcClient getClient() {
        return client;
    }
}
