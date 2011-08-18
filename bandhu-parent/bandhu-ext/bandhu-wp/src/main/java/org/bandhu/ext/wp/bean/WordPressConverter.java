package org.bandhu.ext.wp.bean;

import java.util.Map;

import org.bandhu.core.rpc.annotation.BandhuParser;
import org.bandhu.core.rpc.sp.ext.MetaWeblogConverter;
import org.bandhu.ext.wp.WordPressAccessor;
import org.bandhu.util.BandhuException;

public class WordPressConverter extends MetaWeblogConverter {
    public static Object[] getUserBlogs(WordPressAccessor accessor) {
        return new String[] { accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret() };
    }

    public static Object[] getTags(WordPressAccessor accessor) {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret() };
    }

    public static Object[] getAuthors(WordPressAccessor accessor) {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret() };
    }

    public static Object[] getOptions(WordPressAccessor accessor, Map options) {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), options };
    }

    public static Object[] getComments(WordPressAccessor accessor,
            CommentFilter filter) throws BandhuException {
        Map struct = BandhuParser.toStruct(filter);
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), struct };
    }

    public static Object[] getCommentCount(WordPressAccessor accessor,
            String postId) throws BandhuException {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), postId };
    }

    public static Object[] getComment(WordPressAccessor accessor, int commentId)
            throws BandhuException {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), commentId };
    }

    public static Object[] deleteComment(WordPressAccessor accessor,
            int commentId) throws BandhuException {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), commentId };
    }

    public static Object[] editComment(WordPressAccessor accessor,
            int commentId, Comment comment) throws BandhuException {
        Map struct = BandhuParser.toStruct(comment);
        struct.put("date_created_gmt", comment.getDateCreated());
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), commentId, struct };
    }

    public static Object[] newComment(WordPressAccessor accessor, int postId,
            Comment comment) throws BandhuException {
        Map struct = BandhuParser.toStruct(comment);
        struct.put("comment_parent", comment.getParent());
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), postId, struct };
    }

    public static Object[] getCategories(WordPressAccessor accessor) {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret() };
    }

    public static Object[] newCategory(WordPressAccessor accessor,
            Category category) throws BandhuException {
        Map struct = BandhuParser.toStruct(category);
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), struct };
    }

    public static Object[] deleteCategory(WordPressAccessor accessor,
            int categoryId) throws BandhuException {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret() };
    }

    public static Object[] suggestCategories(WordPressAccessor accessor,
            String category) throws BandhuException {
        return new Object[] { accessor.getBlogId(),
                accessor.getConsumer().getUserId(),
                accessor.getConsumer().getSecret(), category, 15 };
    }
}
