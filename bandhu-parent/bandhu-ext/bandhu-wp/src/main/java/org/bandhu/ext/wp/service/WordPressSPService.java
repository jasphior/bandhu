package org.bandhu.ext.wp.service;

import org.bandhu.core.rpc.sp.RPCServiceProviderService;
import org.bandhu.core.rpc.sp.ext.MetaWeblogService;
import org.bandhu.ext.wp.bean.Author;
import org.bandhu.ext.wp.bean.Blog;
import org.bandhu.ext.wp.bean.Category;
import org.bandhu.ext.wp.bean.Comment;
import org.bandhu.ext.wp.bean.CommentCount;
import org.bandhu.ext.wp.bean.Post;
import org.bandhu.ext.wp.bean.Tag;

public enum WordPressSPService implements RPCServiceProviderService {
    /**
     * wp.getUsersBlogs Parameters string username, string password
     */
    GET_USERS_BLOGS("wp.getUsersBlogs", Blog.class, false),

    /**
     * metaWeblog.newPost (blogid, username, password, struct, publish) returns
     * string
     */
    POST_POST(MetaWeblogService.POST_POST.getMethodName(), String.class, true),

    /**
     * metaWeblog.editPost (postid, username, password, struct, publish) returns
     * true
     */
    EDIT_POST(MetaWeblogService.EDIT_POST.getMethodName(), Boolean.class, true),

    /**
     * metaWeblog.getPost (postid, username, password) returns struct
     */
    GET_POST(MetaWeblogService.GET_POST.getMethodName(), Post.class, true),

    /**
     * metaWeblog.getRecentPosts (blogid, username, password, numberOfPosts)
     * returns array of structs
     */
    GET_POSTS(MetaWeblogService.GET_POSTS.getMethodName(), Post.class, true),

    /**
     * wp.getTags Parameters int blog_id string username string password
     */
    GET_TAGS("wp.getTags", Tag.class, true),

    /**
     * wp.getAuthors Parameters int blog_id string username string password
     */
    GET_AUTHORS("wp.getAuthors", Author.class, true),

    /**
     * wp.getComments Gets a set of comments for a given post. Parameters int
     * blog_id string username string password struct post_id status (defaults
     * to approve) offset number
     */
    GET_COMMENTS("wp.getComments", Comment.class, true),

    /**
     * wp.getCommentCount Retrieve comment count for a specific post.
     * 
     * Parameters int blog_id string username string password string post_id
     */
    GET_COMMENT_COUNT("wp.getCommentCount", CommentCount.class, true),

    /**
     * wp.getComment Gets a comment, given it's comment ID. Note that this isn't
     * in 2.6.1, but is in the HEAD (so should be in anything newer than 2.6.1)
     * 
     * Parameters int blog_id string username string password int comment_id
     */
    GET_COMMENT("wp.getComment", Comment.class, true),

    /**
     * wp.deleteComment Remove comment.
     * 
     * Parameters int blog_id string username string password int comment_id
     */
    DELETE_COMMENT("wp.deleteComment", Boolean.class, true),

    /**
     * wp.editComment Edit comment.
     * 
     * Parameters int blog_id string username string password int comment_id
     * struct comment string status date date_created_gmt string content string
     * author string author_url string author_email
     */
    EDIT_COMMENT("wp.editComment", Boolean.class, true),

    /**
     * wp.newComment Create new comment.
     * 
     * If you want to send anonymous comments, leave the second and third
     * parameter blank and install a filter to xmlrpc_allow_anonymous_comments
     * to return true.
     * 
     * See this WordPress forum post for more details.
     * 
     * Parameters int blog_id string username string password int post_id struct
     * comment int comment_parent string content string author string author_url
     * string author_email
     * 
     */
    POST_COMMENT("wp.newComment", Integer.class, true),

    /**
     * wp.getCategories Get an array of available categories on a blog.
     * 
     * Parameters int blog_id string username string password
     */
    GET_CATEGORIES("wp.getCategories", Category.class, true),

    /**
     * wp.newCategory Create a new category.
     * 
     * Parameters int blog_id string username string password struct string name
     * string slug int parent_id string description
     */
    POST_CATEGORY("wp.newCategory", Integer.class, true),

    /**
     * wp.deleteCategory Delete a category.
     * 
     * Parameters int blog_id string username string password int category_id
     */
    DELETE_CATEGORY("wp.deleteCategory", null, true),

    /**
     * wp.suggestCategories Get an array of categories that start with a given
     * string.
     * 
     * Parameters int blog_id string username string password string category
     * int max_results
     */
    SUGGEST_CATEGORIES("wp.getCategories", Category.class, true), ;

    private String method;
    private Class<?> entity;
    private boolean authenticationRequired;

    WordPressSPService(final String method, final Class<?> entity,
            boolean authenticationRequired) {
        this.method = method;
        this.entity = entity;
        this.authenticationRequired = authenticationRequired;
    }

    public String getMethodName() {
        return method;
    }

    public Class<?> getEntity() {
        return entity;
    }

    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }

}
