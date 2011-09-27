package org.bandhu.ext.gdata.picasa.tst;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.gdata.data.Category;
import com.google.gdata.data.Extension;
import com.google.gdata.data.Link;
import com.google.gdata.data.blogger.CommentEntry;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;

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

    public static void displayPhoto(AlbumFeed feed) throws Exception {
        System.out.println(feed.getId() + " - ");
        String title = feed.getTitle() != null ? feed.getTitle().getPlainText()
                : "";
        String cancomment = feed.isImmutable() ? " no comments"
                : " open for comments";
        System.out.println("\t" + title + cancomment);
        System.out.println("\t" + feed.getCommentCount() + "comments");
        displayLinks(feed.getLinks());
        displayExtns(feed.getExtensions());
        displayCategories(feed.getCategories());
        displayPhoto(feed.getEntries(PhotoEntry.class));
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

    public static void displayPhoto(List<PhotoEntry> photoEntries)
            throws ServiceException {
        displayCount(photoEntries);
        for (PhotoEntry entry : photoEntries) {
            displayPhoto(entry);
        }
    }

    private static void displayPhoto(PhotoEntry entry) throws ServiceException {
        System.out.println(entry.getCommentCount());
        displayLinks(entry.getLinks());
    }

    private static void displayCount(Collection<?> posts) {
        System.out.println("Found " + posts.size() + " entries.");
    }

    public static void displayAlbum(GphotoEntry entry) {
        System.out.println(entry.getTitle().getPlainText());
        System.out.println("categories - ");
        displayCategories(entry.getCategories());
        displayLinks(entry.getLinks());
    }

    public static void displayAlbums(List<GphotoEntry> albums) {
        displayCount(albums);
        for (GphotoEntry entry : albums) {
            displayAlbum(entry);
        }
    }

    public static void displayAlbum(AlbumEntry entry) {
        System.out.println(entry.getTitle().getPlainText());
        System.out.println(entry.getPhotosLeft());
        System.out.println(entry.getPhotosLeftExt());
        System.out.println(entry.getPhotosUsed());
        System.out.println(entry.getPhotosUsedExt());
        System.out.println("categories - ");
        displayCategories(entry.getCategories());
        displayLinks(entry.getLinks());
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
