package org.bandhu.ext.gdata.blogger;

import java.net.URL;
import java.util.List;

import org.bandhu.ext.gdata.blogger.tst.Util;
import org.bandhu.util.BandhuException;

import com.google.gdata.client.Query;
import com.google.gdata.data.Entry;
import com.google.gdata.data.Feed;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.blogger.BlogCommentFeed;
import com.google.gdata.data.blogger.BloggerLink;
import com.google.gdata.data.blogger.CommentEntry;

public class BloggerService {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
            .getLogger(BloggerService.class);

    public List<Entry> getUserBlogs(BloggerAccessor accessor)
            throws BandhuException {
        LOG.debug("entered getUserBlogs");
        Feed feed;
        try {
            feed = accessor.getService().getFeed(
                    new URL(accessor.METAFEEDURL), Feed.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("getUserBlogs : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed getUserBlogs");
        return feed.getEntries();
    }

    public Entry doPost(BloggerAccessor accessor, Entry entry)
            throws BandhuException {
        LOG.debug("entered doPost");
        try {
            entry = accessor.getService().insert(
                    new URL(accessor.getBlog()
                            .getLink(Rel.ENTRY_POST, Type.ATOM).getHref()),
                    entry);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("doPost : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed doPost");
        return entry;
    }

    public Entry editPost(BloggerAccessor accessor, Entry toEdit, Entry entry)
            throws BandhuException {
        LOG.debug("entered editPost");
        try {
            entry = accessor.getService()
                    .update(new URL(toEdit.getLink(Rel.ENTRY_EDIT, Type.ATOM)
                            .getHref()), entry);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("editPost : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed editPost");
        return entry;
    }

    public List<Entry> getPosts(BloggerAccessor accessor)
            throws BandhuException {
        LOG.debug("entered getPosts");
        Feed feed;
        try {
            feed = accessor.getService().getFeed(
                    new URL(accessor.getBlog()
                            .getLink(Rel.ENTRY_POST, Type.ATOM).getHref()),
                    Feed.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("getPosts : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed getPosts");
        return feed.getEntries();
    }

    public void deletePost(BloggerAccessor accessor, Entry entry)
            throws BandhuException {
        LOG.debug("entered deletePost");
        try {
            accessor.getService().delete(
                    new URL(entry.getLink(Rel.SELF, Type.ATOM).getHref()));
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("deletePost : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed deletePost");
    }

    public BlogCommentFeed getComments(BloggerAccessor accessor, Entry entry)
            throws BandhuException {
        LOG.debug("entered getPosts");
        BlogCommentFeed feed;
        try {
            feed = accessor.getService().getFeed(
                    new URL(entry.getLink(BloggerLink.Rel.REPLIES, Type.ATOM)
                            .getHref()), BlogCommentFeed.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("getPosts : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed getPosts");
        System.out.println("--");
        Util.displayLinks(feed.getLinks());
        return feed;
    }

    public CommentEntry postComment(BloggerAccessor accessor,
            BlogCommentFeed feed, CommentEntry commentEntry)
            throws BandhuException {
        LOG.debug("entered postComment");
        try {
            commentEntry = accessor.getService().insert(
                    new URL(feed.getLink(Rel.SELF, Type.ATOM).getHref()),
                    commentEntry);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("postComment : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed postComment");
        return commentEntry;
    }

    public CommentEntry postComment(BloggerAccessor accessor, Entry post,
            CommentEntry commentEntry) throws BandhuException {
        LOG.debug("entered postComment");
        try {
            BlogCommentFeed feed = accessor.getService().getFeed(
                    new URL(post.getLink(BloggerLink.Rel.REPLIES, Type.ATOM)
                            .getHref()), BlogCommentFeed.class);
            commentEntry = accessor.getService().insert(
                    new URL(feed.getLink(Rel.SELF, Type.ATOM).getHref()),
                    commentEntry);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("postComment : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed postComment");
        return commentEntry;
    }

    public CommentEntry postCommentReply(BloggerAccessor accessor, Entry post,
            CommentEntry commentEntry) throws BandhuException {
        LOG.debug("entered replyComment");
        try {
            commentEntry = accessor
                    .getService()
                    .insert(new URL(
                            post.getLink(
                                    com.google.gdata.data.blogger.BloggerLink.Rel.REPLIES,
                                    Type.ATOM).getHref()), commentEntry);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("replyComment : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed replyComment");
        return commentEntry;
    }

    public void deleteComment(BloggerAccessor accessor,
            CommentEntry commentEntry) throws BandhuException {
        LOG.debug("entered deleteComment");
        try {
            accessor.getService()
                    .delete(new URL(commentEntry.getLink(Rel.SELF, Type.ATOM)
                            .getHref()));
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("deleteComment : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed deleteComment");
    }

    public List<Entry> query(BloggerAccessor accessor, Query query)
            throws BandhuException {
        LOG.debug("entered getPosts");
        Feed feed;
        try {
            feed = accessor.getService().query(query, Feed.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("getPosts : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed getPosts");
        return feed.getEntries();
    }

}
