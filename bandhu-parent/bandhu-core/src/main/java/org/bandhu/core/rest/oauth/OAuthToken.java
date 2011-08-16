package org.bandhu.core.rest.oauth;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.bandhu.core.rest.oauth.OAuthService.Call;
import org.bandhu.util.BandhuUtil;

import com.sun.jersey.oauth.signature.OAuthParameters;

public class OAuthToken {
    private Map<String, String> params = new HashMap<String, String>();

    private int type;

    public OAuthToken(int type) {
        this.type = type;
    }

    public OAuthToken(String key, String secret) {
        addParam(OAuthParameters.TOKEN, key);
        addParam(OAuthParameters.TOKEN_SECRET, secret);
    }

    public static OAuthToken parse(Call call, String string) {
        OAuthToken token = new OAuthToken(call.ordinal());
        String[] info = BandhuUtil.stringSplitter(string,
                OAuthConstants.PARAMETER_DELIMITER);
        for (String string2 : info) {
            String[] keyVal = BandhuUtil.stringSplitter(string2,
                    OAuthConstants.KEY_VAL_DELIMITER);
            if (keyVal.length == 2)
                token.addParam(keyVal[0], keyVal[1]);
        }
        return token;
    }

    public void setVerifier(String verifier) {
        if (BandhuUtil.hasText(verifier)) {
            params.put(OAuthParameters.VERIFIER, verifier);
        }
    }

    public String getToken() {
        Object obj = null;
        if (type == 0) {
            obj = params.get(OAuthConstants.TOKEN);
        } else {
            obj = params.get(OAuthConstants.ACCESS_TOKEN);
            // access_token can be null too... (depends on service provider) its
            // ok... in that case we can continue with oauth_token
            obj = (obj == null) ? params.get(OAuthConstants.TOKEN) : obj;
        }
        return obj != null ? String.valueOf(obj) : null;
    }

    public String getTokenSecret() {
        Object obj = params.get(OAuthConstants.TOKEN_SECRET);
        return obj != null ? String.valueOf(obj) : null;
    }

    public boolean getCallBackConfirmed() {
        Object obj = params.get(OAuthConstants.CALLBACK_CONFIRMED);
        return obj != null ? Boolean.parseBoolean(String.valueOf(obj)) : null;
    }

    public int getExpiry() {
        Object obj = params.get(OAuthConstants.OAUTH_AUTH_EXPIRY);
        return obj != null ? Integer.valueOf(String.valueOf(obj)) : null;
    }

    public String getAuthUrl() {
        Object obj = params.get(OAuthConstants.AUTH_URL);
        return obj != null ? URLDecoder.decode(String.valueOf(obj)) : null;
    }

    public String getRealm() {
        Object obj = params.get(OAuthConstants.REALM);
        return obj != null ? String.valueOf(obj) : null;
    }

    public String getVerifier() {
        Object obj = params.get(OAuthConstants.VERIFIER);
        return obj != null ? String.valueOf(obj) : null;
    }

    public void addParam(String key, String value) {
        params.put(key, value);
    }

    public String getParam(String key) {
        return params.get(key);
    }

    public Map<String, String> getParams() {
        return params;
    }

    // public Map<String, String> getSessionParameters() {
    // Map<String, String> sessionParams = new HashMap<String, String>();
    // for (String prm : OAuthConstants.SESSION_PARAMS) {
    // if (params.containsKey(prm))
    // sessionParams.put(prm, params.get(prm));
    // }
    // return sessionParams;
    // }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OAuth4JToken [params=").append(params).append("]");
        return builder.toString();
    }

}