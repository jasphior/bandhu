package org.bandhu.ext.gdata.picasa.tst;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import junit.framework.TestCase;

import org.bandhu.core.Consumer;
import org.bandhu.ext.gdata.picasa.PicasaAccessor;
import org.bandhu.ext.gdata.picasa.PicasaService;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.media.MediaSource;
import com.google.gdata.data.media.MediaStreamSource;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.PhotoEntry;

public class Test extends TestCase {
    PicasaService service = new PicasaService();
    PicasaAccessor accessor;

    @Override
    protected void setUp() throws Exception {
        // TODO Auto-generated method stub
        super.setUp();
        Consumer consumer = new Consumer("jasphior", "sensebag");
        PicasawebService googleService = new PicasawebService("demo");
        googleService.setUserCredentials("jasphior@gmail.com", "sensebag");
        accessor = new PicasaAccessor(googleService, consumer);
    }

    private void testGetAlbums() throws Exception {
        System.out.println("Getting Picasa Web Albums entries...\n");
        List<GphotoEntry> entries = service.getUserAlbums(accessor);
        Util.displayAlbums(entries);
        System.out.println("\nTotal Entries: " + entries.size());
    }

    private void testCreateAlbums() throws Exception {
        AlbumEntry ge = new AlbumEntry();
        System.out.println("enter album name");
        ge.setTitle(new PlainTextConstruct(new Scanner(System.in).nextLine()));
        System.out.println("enter album desc");
        ge.setDescription(new PlainTextConstruct(new Scanner(System.in)
                .nextLine()));
        AlbumEntry entry = service.createAlbum(accessor, ge);
        Util.displayAlbum(entry);
    }

    private void testUploadPhoto() throws Exception {
        List<GphotoEntry> entries = service.getUserAlbums(accessor);
        Util.displayAlbums(entries);
        GphotoEntry album = entries.get(new Scanner(System.in).nextInt() - 1);
        PhotoEntry photoEntry = new PhotoEntry();
        photoEntry.setAlbumId(album.getId());
        photoEntry.setTitle(new PlainTextConstruct(String.valueOf(System
                .currentTimeMillis())));

        System.out.println("enter media location");
        String loc = new Scanner(System.in).nextLine();

        MediaSource src = null;
        if (loc.contains("http")) {
            InputStream openStream = new URL(loc).openStream();
            src = new MediaStreamSource(openStream, "image/jpeg");
        } else {
            InputStream openStream = new FileInputStream(new File(loc));
            src = new MediaStreamSource(openStream, "image/jpeg");
        }

        photoEntry.setMediaSource(src);
        PhotoEntry entry = service.addPhoto(accessor,
                album.getLink(Rel.FEED, Type.ATOM).getHref(), photoEntry);
        Util.displayAlbum(entry);
    }

    public void testBrowseAlbum() throws Exception {
        List<GphotoEntry> entries = service.getUserAlbums(accessor);
        Util.displayAlbums(entries);
        GphotoEntry album = entries.get(new Scanner(System.in).nextInt() - 1);
        AlbumFeed feed = service.browseAlbum(accessor,
                album.getLink(Rel.FEED, Type.ATOM).getHref(), album);
        Util.displayPhoto(feed);
    }
}
