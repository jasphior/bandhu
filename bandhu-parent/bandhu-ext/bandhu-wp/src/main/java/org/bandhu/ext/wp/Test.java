package org.bandhu.ext.wp;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class Test {
    static {
        System.setProperty("http.proxyHost", "proxy.symphonysv.com");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "proxy.symphonysv.com");
        System.setProperty("https.proxyPort", "8080");
    }

    public static void main(String[] args) throws Exception {
        // blog();
        // Map<String, Object> map = new HashMap<String, Object>();
        // map.put("name", "newxyz");
        // addCategory(1, map);
        // getCategory(1);
        // getRecentPosts();
        getTags();
    }

    static String xmlRpcUrl = "https://nikasaya.wordpress.com/xmlrpc.php";
    static Object[] idpwd = new Object[] { "jasphior", "sensepress" };

    private static void getTags() throws Exception {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(xmlRpcUrl));

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        execute("wp.getTags", client, 1, idpwd[0], idpwd[1]);
    }

    public static void blog() throws Exception {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(xmlRpcUrl));

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        execute("wp.getUsersBlogs", client, idpwd);

        XmlRpcClient client2 = new XmlRpcClient();
        client2.setConfig(config);

        Map<String, Object> content = new HashMap<String, Object>();
        content.put("title", "img my api - 4!");
        content.put("categories", new Object[] { "newcat", "test", "api" });
        String simple = "from my api... cool!!";
        String html = "<ol><li>You can find new ideas for what to blog about by reading <a title=\"The Daily Post at WordPress.com—post something every day\" href=\"http://dailypost.wordpress.com/\">the Daily Post</a>.</li>"
                + "<li>asd</li><li><a title=\"Edit the first post on this blog.\" href=\"/wp-admin/post.php?post=1&amp;action=edit\">Make some changes to this page</a>, and then hit preview on the right. You can alway preview any post or edit you before you share it to the world.</li></ol>";
        String htmlimg = simple
                + "<img alt=\"img\" title=\"my img\" src=\"http://www.google.co.in/images/srpr/nav_logo71.png\"/>";
        content.put("description", htmlimg);

        Object[] postparams = new Object[] { "", "1", idpwd[0], idpwd[1],
                content, true };
        execute("metaWeblog.newPost", client2, postparams);
    }

    static void addCategory(int blogId, Map struct) throws Exception {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(xmlRpcUrl));

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Object[] postparams = new Object[] { blogId, idpwd[0], idpwd[1], struct };

        // Map<String, Object> pra = new HashMap<String, Object>();
        // pra.put("blog_id", blogId);
        // pra.put("username", idpwd[0]);
        // pra.put("password", idpwd[1]);
        // pra.put("struct", struct);
        execute("wp.newCategory", client, postparams);
    }

    static void getCategory(int blogId) throws Exception {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(xmlRpcUrl));

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Object[] postparams = new Object[] { blogId, idpwd[0], idpwd[1] };
        execute("wp.getCategories", client, postparams);
    }

    static void getRecentPosts() throws Exception {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(xmlRpcUrl));

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Object[] postparams = new Object[] { 1, idpwd[0], idpwd[1] };
        execute("metaWeblog.getRecentPosts", client, postparams);

    }

    static void execute(String string, XmlRpcClient client, Object... params)
            throws XmlRpcException {
        Object response = client.execute(string, params);
        if (response.getClass().isArray()) {
            System.out.println("Found Array!!");
            Object[] responseObjs = (Object[]) response;
            for (Object object : responseObjs) {
                System.out.println(object.getClass().getSimpleName());
                System.out.println(object);
            }
        } else {
            System.out.println(response.getClass().getSimpleName());
            System.out.println(response);
        }
    }
}
