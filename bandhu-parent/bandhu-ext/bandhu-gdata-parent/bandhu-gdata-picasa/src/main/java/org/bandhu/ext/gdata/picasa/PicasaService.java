package org.bandhu.ext.gdata.picasa;

import java.net.URL;
import java.util.List;

import org.bandhu.util.BandhuException;

import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.data.photos.UserFeed;

public class PicasaService {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
            .getLogger(PicasaService.class);

    public List<GphotoEntry> getUserAlbums(PicasaAccessor accessor)
            throws BandhuException {
        LOG.debug("entered getUserBlogs");
        UserFeed userFeed;
        try {
            userFeed = accessor.getService().getFeed(
                    new URL(accessor.getMetafeedURL()), UserFeed.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("getUserBlogs : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed getUserBlogs");
        return userFeed.getEntries();
    }

    public AlbumEntry createAlbum(PicasaAccessor accessor, AlbumEntry entry)
            throws BandhuException {
        LOG.debug("entered getUserBlogs");
        try {
            entry = accessor.getService().insert(
                    new URL(accessor.getMetafeedURL()), entry);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("getUserBlogs : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed getUserBlogs");
        return entry;
    }

    public PhotoEntry addPhoto(PicasaAccessor accessor, String id,
            PhotoEntry photoEntry) throws BandhuException {
        LOG.debug("entered getUserBlogs");
        try {
            photoEntry = accessor.getService().insert(new URL(id), photoEntry);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("getUserBlogs : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed getUserBlogs");
        return photoEntry;
    }

    public AlbumFeed browseAlbum(PicasaAccessor accessor, String href,
            GphotoEntry album) throws BandhuException {
        LOG.debug("entered getUserBlogs");
        AlbumFeed albumFeed;
        try {
            albumFeed = accessor.getService().getFeed(
                    new URL(album.getLink(Rel.FEED, Type.ATOM).getHref()),
                    AlbumFeed.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("getUserBlogs : " + e.getMessage());
            throw new BandhuException(e);
        }
        LOG.debug("executed getUserBlogs");
        return albumFeed;
    }

}
