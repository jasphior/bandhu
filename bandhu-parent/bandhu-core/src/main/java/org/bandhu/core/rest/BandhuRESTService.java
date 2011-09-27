package org.bandhu.core.rest;

import org.bandhu.core.BandhuRequest;
import org.bandhu.core.Consumer;
import org.bandhu.core.ServiceAccessor;
import org.bandhu.util.BandhuException;
import org.bandhu.util.BandhuUtil;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class BandhuRESTService extends ServiceAccessor {

    public BandhuRESTService(String id, Consumer consumer)
            throws BandhuException {
        super(id, consumer);
    }

    public BandhuRESTService(Consumer consumer) throws BandhuException {
        super(consumer);
    }

    public <T> Object execute(WebResource resource, BandhuRequest request,
            Class<T> entity) throws BandhuException {
        // WebResource resource = request.getClient().resource(
        // request.getEndpoint());
        // request.buildWebResource();
        T response = null;
        switch (request.getMethod()) {
        case GET:
            response = resource.get(entity);
            break;
        case POST:
            if (!BandhuUtil.hasValue(request.getPayload()))
                response = resource.post(entity);
            else
                response = resource.post(entity, request.getPayload());
            break;
        case PUT:
            if (!BandhuUtil.hasValue(request.getPayload()))
                response = resource.put(entity);
            else
                response = resource.put(entity, request.getPayload());
            break;
        case DELETE:
            response = resource.delete(entity);
            break;
        case OPTIONS:
            response = resource.options(entity);
            break;
        case HEAD:
            response = (T) resource.head();
            break;
        default:
            response = resource.post(entity);
            break;
        }

        if (response instanceof ClientResponse) {
            ClientResponse cr = (ClientResponse) response;
            if (cr.getStatus() >= 300) {
                System.out.println(cr.getEntity(String.class));
                throw new BandhuException("Error occured with status - "
                        + cr.getStatus());
            }
        }
        return response;
    }
}
