package org.bandhu.ext.wp;

import java.util.List;

import org.bandhu.core.rpc.annotation.BandhuParser;
import org.bandhu.ext.wp.bean.Author;
import org.bandhu.ext.wp.bean.Blog;
import org.bandhu.ext.wp.bean.Category;
import org.bandhu.ext.wp.bean.Comment;
import org.bandhu.ext.wp.bean.CommentCount;
import org.bandhu.ext.wp.bean.CommentFilter;
import org.bandhu.ext.wp.bean.Post;
import org.bandhu.ext.wp.bean.Tag;
import org.bandhu.ext.wp.bean.WordPressConverter;
import org.bandhu.ext.wp.service.WordPressSPService;
import org.bandhu.util.BandhuException;

public class WordPressService {
    public static final String PROCESS_FAILURE = "Unable to process the request!";

    public List<Blog> getUserBlogs(WordPressAccessor accessor)
            throws BandhuException {
        List<Blog> blogs = (List<Blog>) execute(accessor,
                WordPressSPService.GET_USERS_BLOGS, accessor);
        return blogs;
    }

    public String doPost(WordPressAccessor accessor, Post post)
            throws BandhuException {
        String postId = (String) execute(accessor,
                WordPressSPService.POST_POST, WordPressConverter.post(accessor
                        .getBlogId(), accessor.getConsumer().getUserId(),
                        accessor.getConsumer().getSecret(), post, post
                                .isPublish()));
        return postId;
    }

    public Boolean editPost(WordPressAccessor accessor, String postId, Post post)
            throws BandhuException {
        Boolean result = (Boolean) execute(accessor,
                WordPressSPService.EDIT_POST, WordPressConverter.editPost(
                        postId, accessor.getConsumer().getUserId(), accessor
                                .getConsumer().getSecret(), post, post
                                .isPublish()));
        return result;
    }

    public Post getPost(WordPressAccessor accessor, String postId)
            throws BandhuException {
        Post post = (Post) execute(accessor, WordPressSPService.GET_POSTS,
                WordPressConverter.getPost(postId, accessor.getConsumer()
                        .getUserId(), accessor.getConsumer().getSecret()));
        return post;
    }

    public List<Post> getPosts(WordPressAccessor accessor)
            throws BandhuException {
        List<Post> posts = (List<Post>) execute(accessor,
                WordPressSPService.GET_POST, WordPressConverter.getPosts(
                        accessor.getBlogId(), accessor.getConsumer()
                                .getUserId(), accessor.getConsumer()
                                .getSecret(), 100));
        return posts;
    }

    public List<Tag> getTags(WordPressAccessor accessor) throws BandhuException {
        List<Tag> tags = (List<Tag>) execute(accessor,
                WordPressSPService.GET_TAGS,
                WordPressConverter.getTags(accessor));
        return tags;
    }

    public List<Author> getAuthors(WordPressAccessor accessor)
            throws BandhuException {
        List<Author> authors = (List<Author>) execute(accessor,
                WordPressSPService.GET_AUTHORS,
                WordPressConverter.getAuthors(accessor));
        return authors;
    }

    public List<Comment> getComments(WordPressAccessor accessor,
            CommentFilter filter) throws BandhuException {
        List<Comment> comments = (List<Comment>) execute(accessor,
                WordPressSPService.GET_COMMENTS,
                WordPressConverter.getComments(accessor, filter));
        return comments;
    }

    public CommentCount getCommentCount(WordPressAccessor accessor,
            String postId) throws BandhuException {
        CommentCount counts = (CommentCount) execute(accessor,
                WordPressSPService.GET_COMMENT_COUNT,
                WordPressConverter.getCommentCount(accessor, postId));
        return counts;
    }

    public Comment getComment(WordPressAccessor accessor, int commentId)
            throws BandhuException {
        Comment comment = (Comment) execute(accessor,
                WordPressSPService.GET_COMMENT,
                WordPressConverter.getComment(accessor, commentId));
        return comment;
    }

    public Boolean deleteComment(WordPressAccessor accessor, int commentId)
            throws BandhuException {
        Boolean result = (Boolean) execute(accessor,
                WordPressSPService.DELETE_COMMENT,
                WordPressConverter.deleteComment(accessor, commentId));
        return result;
    }

    public Boolean editComment(WordPressAccessor accessor, int commentId,
            Comment comment) throws BandhuException {
        Boolean result = (Boolean) execute(accessor,
                WordPressSPService.EDIT_COMMENT,
                WordPressConverter.editComment(accessor, commentId, comment));
        return result;
    }

    public Boolean postComment(WordPressAccessor accessor, int postId,
            Comment comment) throws BandhuException {
        Boolean result = (Boolean) execute(accessor,
                WordPressSPService.POST_COMMENT,
                WordPressConverter.newComment(accessor, postId, comment));
        return result;
    }

    public List<Category> getCategories(WordPressAccessor accessor)
            throws BandhuException {
        List<Category> result = (List<Category>) execute(accessor,
                WordPressSPService.GET_CATEGORIES,
                WordPressConverter.getCategories(accessor));
        return result;
    }

    public Integer postCategory(WordPressAccessor accessor, Category category)
            throws BandhuException {
        Integer result = (Integer) execute(accessor,
                WordPressSPService.POST_CATEGORY,
                WordPressConverter.newCategory(accessor, category));
        return result;
    }

    public Object deleteCategory(WordPressAccessor accessor, int categoryId)
            throws BandhuException {
        return execute(accessor, WordPressSPService.DELETE_CATEGORY,
                WordPressConverter.deleteCategory(accessor, categoryId));
    }

    public List<Category> suggestCategories(WordPressAccessor accessor,
            String category) throws BandhuException {
        List<Category> result = (List<Category>) execute(accessor,
                WordPressSPService.SUGGEST_CATEGORIES,
                WordPressConverter.suggestCategories(accessor, category));
        return result;
    }

    private Object execute(WordPressAccessor accessor,
            WordPressSPService service, Object... params)
            throws BandhuException {
        try {
            Object response = accessor.getClient().execute(
                    service.getMethodName(), params);
            Class<?> entity = service.getEntity();
            if (entity == null) {
                entity = String.class;
            }
            return BandhuParser.parse(entity, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BandhuException(PROCESS_FAILURE);
        }
    }

}
