package org.bandhu.core.rpc;

import org.bandhu.core.Consumer;
import org.bandhu.core.ServiceAccessor;
import org.bandhu.util.BandhuException;

public class RPCService extends ServiceAccessor {

    public RPCService(Consumer consumer) throws BandhuException {
        super(consumer);
    }

    public RPCService(String id, Consumer consumer) throws BandhuException {
        super(id, consumer);
    }
}
