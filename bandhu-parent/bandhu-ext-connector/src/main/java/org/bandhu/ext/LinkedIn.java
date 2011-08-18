package org.bandhu.ext;

import org.bandhu.core.bean.Board;
import org.bandhu.core.rest.oauth.OAuthRequest;
import org.bandhu.core.rest.oauth.OAuthService;
import org.bandhu.ext.linkedin.service.LinkedInSPService;
import org.bandhu.util.BandhuException;

public class LinkedIn {
    OAuthService service;

    public void getUpdates() throws BandhuException {
        service.createRequest(LinkedInSPService.UPDATES, "count=2").process();
    }

    public void postMessage(Board board) throws BandhuException {
        OAuthRequest request = service
                .createRequest(LinkedInSPService.POSTING_UPDATES);
        request.setPayload(board.getContent());
        request.process();
    }

    public void postComment(Board board) throws BandhuException {
        OAuthRequest request = service.createRequest(
                LinkedInSPService.POSTING_COMMENT, null, board.getTarget());
        request.setPayload(board.getContent());
        request.process();
    }

    public void postShare(Board board) throws BandhuException {
        OAuthRequest request = service
                .createRequest(LinkedInSPService.POSTING_SHARES);
        request.setPayload(board.getContent());
        request.process();
    }
}
