package org.bandhu.ext.gdata.blogger.tst;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

import junit.framework.TestCase;

import org.bandhu.core.Consumer;
import org.bandhu.ext.gdata.blogger.BloggerAccessor;
import org.bandhu.ext.gdata.blogger.BloggerService;

import com.google.gdata.client.Query;
import com.google.gdata.client.Query.CategoryFilter;
import com.google.gdata.data.Category;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.Entry;
import com.google.gdata.data.HtmlTextConstruct;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.blogger.BlogCommentFeed;
import com.google.gdata.data.blogger.CommentEntry;
import com.google.gdata.data.threading.InReplyTo;

public class Test extends TestCase {
    BloggerService bloggerService = new BloggerService();
    BloggerAccessor accessor;

    @Override
    protected void setUp() throws Exception {
        // TODO Auto-generated method stub
        super.setUp();
        Consumer consumer = null;
        com.google.gdata.client.blogger.BloggerService googleService = new com.google.gdata.client.blogger.BloggerService(
                "demo");

        googleService.setUserCredentials("jasphior", "sensebag");
        Entry blog = null;
        accessor = new BloggerAccessor(googleService, blog, consumer);

        List<Entry> blogs = bloggerService.getUserBlogs(accessor);
        Util.displayBlogs(blogs);
        blog = blogs.get(new Scanner(System.in).nextInt() - 1);

        accessor = new BloggerAccessor(googleService, blog, consumer);
    }

    private void testGetPosts() throws Exception {
        List<Entry> posts = bloggerService.getPosts(accessor);
        Util.displayPosts(posts);
    }

    private void testPost() throws Exception {
        Entry entry = new Entry();
        HtmlTextConstruct content = new HtmlTextConstruct();
        System.out.println("enter title");
        entry.setTitle(new PlainTextConstruct(new Scanner(System.in).nextLine()));
        System.out.println("enter post");
        content.setHtml(new Scanner(System.in).nextLine());
        System.out.println("enter cats");
        String cats = new Scanner(System.in).nextLine();
        for (String cat : cats.split(",")) {
            entry.getCategories().add(
                    new Category(BloggerAccessor.CATEGORY_NS_URL, cat));
        }
        entry.setContent(content);
        entry.setDraft(false);
        Entry post = bloggerService.doPost(accessor, entry);
        Util.displayLinks(post.getLinks());
    }

    private void testEditPost() throws Exception {
        Entry entry = new Entry();
        entry.setTitle(new PlainTextConstruct("edited post"));
        entry.setContent(new PlainTextConstruct(
                "This has been updated again from api!!"));
        List<Entry> posts = bloggerService.getPosts(accessor);
        Util.displayPosts(posts);
        Entry toEdit = posts.get(0);
        System.out.println("B4");
        Util.displayLinks(toEdit.getLinks());
        Entry post = bloggerService.editPost(accessor, toEdit, entry);
        System.out.println("L8R");
        Util.displayLinks(post.getLinks());

        testGetPosts();
    }

    private void testDeletePost() throws Exception {
        List<Entry> posts = bloggerService.getPosts(accessor);
        Util.displayPosts(posts);
        bloggerService.deletePost(accessor,
                posts.get(new Scanner(System.in).nextInt() - 1));
        testGetPosts();
    }

    private void testGetComments() throws Exception {
        List<Entry> posts = bloggerService.getPosts(accessor);
        Util.displayPosts(posts);
        BlogCommentFeed commentEntries = bloggerService.getComments(accessor,
                posts.get(new Scanner(System.in).nextInt() - 1));
        Util.displayComments(commentEntries.getEntries());
    }

    private void testPostComment() throws Exception {
        List<Entry> posts = bloggerService.getPosts(accessor);
        Util.displayPosts(posts);
        Entry post = posts.get(new Scanner(System.in).nextInt() - 1);
        CommentEntry commentEntry = new CommentEntry();
        System.out.println("enter comment");
        commentEntry.setContent(new PlainTextConstruct(new Scanner(System.in)
                .nextLine()));
        System.out.println("enter schema");
        String schema = new Scanner(System.in).nextLine();
        System.out.println("enter cats");
        String cats = new Scanner(System.in).nextLine();
        for (String cat : cats.split(",")) {
            commentEntry.getCategories().add(new Category(schema, cat));
        }
        CommentEntry aftr = bloggerService.postComment(accessor, post,
                commentEntry);
        Util.displayCommentEntry(aftr);
    }

    private void testDeleteComment() throws Exception {
        List<Entry> posts = bloggerService.getPosts(accessor);
        Util.displayPosts(posts);
        BlogCommentFeed commentEntries = bloggerService.getComments(accessor,
                posts.get(new Scanner(System.in).nextInt() - 1));
        List<CommentEntry> entries = commentEntries.getEntries();
        Util.displayComments(entries);
        System.out.println("Select comment to delete..");
        bloggerService.deleteComment(accessor,
                entries.get(new Scanner(System.in).nextInt() - 1));
    }

    private void testReplyComment() throws Exception {
        List<Entry> posts = bloggerService.getPosts(accessor);
        Util.displayPosts(posts);
        Entry post = posts.get(new Scanner(System.in).nextInt() - 1);
        BlogCommentFeed feed = bloggerService.getComments(accessor, post);
        List<CommentEntry> commentEntries = feed.getEntries();
        Util.displayComments(commentEntries);
        CommentEntry toReply = commentEntries.get(new Scanner(System.in)
                .nextInt() - 1);
        CommentEntry commentEntry = new CommentEntry();
        InReplyTo inReplyTo = new InReplyTo();
        inReplyTo.setRef(toReply.getLink(Rel.SELF, Type.ATOM).getHref());
        commentEntry.setInReplyTo(inReplyTo);
        commentEntry.setContent(new PlainTextConstruct("I replied!!"));
        CommentEntry aftr = bloggerService.postCommentReply(accessor, post,
                commentEntry);
        Util.displayCommentEntry(aftr);
    }

    private void testQuery() throws Exception {
        URL feedUrl = new URL(accessor.getBlog().getLink(Rel.FEED, Type.ATOM)
                .getHref());
        System.out.println(feedUrl);
        Query query = new Query(feedUrl);
        CategoryFilter cf1 = new CategoryFilter(new Category(
                BloggerAccessor.CATEGORY_NS_URL, "api"));
        query.addCategoryFilter(cf1);
        List<Entry> posts = bloggerService.query(accessor, query);
        Util.displayPosts(posts);
    }

    public void testMMPost() throws Exception {
        Entry entry = new Entry();
        HtmlTextConstruct content = new HtmlTextConstruct();
        System.out.println("enter title");
        entry.setTitle(new PlainTextConstruct(new Scanner(System.in).nextLine()));
        System.out.println("enter post");
        content.setHtml(new Scanner(System.in).nextLine());
        System.out.println("enter cats");
        String cats = new Scanner(System.in).nextLine();
        for (String cat : cats.split(",")) {
            entry.getCategories().add(
                    new Category(BloggerAccessor.CATEGORY_NS_URL, cat));
        }
        entry.setContent(content);
        entry.setDraft(false);
        System.out.println("enter delay time");
        DateTime posttime = new DateTime(System.currentTimeMillis()
                + new Scanner(System.in).nextLong(), 330);
        entry.setPublished(posttime);
        Entry post = bloggerService.doPost(accessor, entry);
        Util.displayLinks(post.getLinks());
    }
}
