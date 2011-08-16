package org.bandhu.core.rpc;

import org.bandhu.core.Consumer;
import org.bandhu.core.ServiceAccessor;

public class RPCService extends ServiceAccessor {

    public RPCService(Consumer consumer) {
        super(consumer.getUserId(), consumer);
    }
}
