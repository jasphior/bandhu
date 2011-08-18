package org.bandhu.core.rpc.sp.ext;

import java.util.Map;

import org.bandhu.core.rpc.annotation.BandhuParser;
import org.bandhu.util.BandhuException;

public class MetaWeblogConverter {
    public static Object[] post(int blogId, String userName, String password,
            Object object, boolean publish) throws BandhuException {
        Map struct = BandhuParser.toStruct(object);
        return new Object[] { blogId, userName, password, struct, publish };
    }

    public static Object[] editPost(String postId, String userName,
            String password, Object object, boolean publish)
            throws BandhuException {
        Map struct = BandhuParser.toStruct(object);
        return new Object[] { postId, userName, password, struct, publish };
    }

    public static Object[] getPost(String postId, String userName,
            String password) throws BandhuException {
        return new Object[] { postId, userName, password };
    }

    public static Object[] getPosts(int blogId, String userName,
            String password, int numberOfPosts) throws BandhuException {
        return new Object[] { blogId, userName, password, numberOfPosts };
    }
}
