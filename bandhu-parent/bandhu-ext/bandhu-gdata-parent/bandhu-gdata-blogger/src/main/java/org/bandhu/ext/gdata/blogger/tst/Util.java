package org.bandhu.ext.gdata.blogger.tst;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.gdata.data.Category;
import com.google.gdata.data.Entry;
import com.google.gdata.data.Extension;
import com.google.gdata.data.Link;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.data.TextContent;
import com.google.gdata.data.blogger.CommentEntry;

public class Util {

    public static void displayLinks(List<Link> links) {
        displayCount(links);
        for (Link link : links) {
            displayLink(link);
        }
    }

    public static void displayLink(Link link) {
        System.out.println(link.getRel() + " - " + link.getType() + " - "
                + link.getHref());
    }

    public static void displayPost(Entry entry) {
        System.out.println(entry.getId() + " - ");
        String title = entry.getTitle() != null ? entry.getTitle()
                .getPlainText() : "";
        String draft = entry.isDraft() ? " (draft)" : "";
        String cancomment = entry.isImmutable() ? " no comments"
                : " open for comments";
        System.out.println("\t" + title + draft + cancomment);
        TextContent txtContent = (TextContent) entry.getContent();
        TextConstruct content = txtContent.getContent();
        System.out.println("\t" + content.getPlainText());
        displayLinks(entry.getLinks());
        displayExtns(entry.getExtensions());
        displayCategories(entry.getCategories());
    }

    private static void displayCategories(Set<Category> categories) {
        for (Category category : categories) {
            System.out.println(category.getLabel() + " - " + category.getTerm()
                    + " - " + category.getScheme());
        }
    }

    private static void displayExtns(Collection<Extension> extensions) {
        displayCount(extensions);
        for (Extension extension : extensions) {
            displayExtn(extension);
        }
    }

    private static void displayExtn(Extension extension) {
        System.out.println(extension.toString());
    }

    public static void displayPosts(List<Entry> posts) {
        displayCount(posts);
        for (Entry entry : posts) {
            displayPost(entry);
        }
    }

    private static void displayCount(Collection<?> posts) {
        System.out.println("Found " + posts.size() + " entries.");
    }

    public static void displayBlogs(List<Entry> blogs) {
        displayCount(blogs);
        for (Entry entry : blogs) {
            displayBlog(entry);
        }
    }

    private static void displayBlog(Entry entry) {
        System.out.println(entry.getTitle().getPlainText());
        System.out.println("categories - ");
        displayCategories(entry.getCategories());
    }

    public static void displayComments(List<CommentEntry> commentEntries) {
        displayCount(commentEntries);
        for (CommentEntry entry : commentEntries) {
            displayCommentEntry(entry);
        }
    }

    public static void displayCommentEntry(CommentEntry entry) {
        System.out.println(entry.getTextContent().getContent().getPlainText()
                + " on " + entry.getUpdated().toUiString() + " by "
                + entry.getAuthors().get(0).getName() + "("
                + entry.getAuthors().get(0).getEmail() + ")");
        displayLinks(entry.getLinks());
    }
}
