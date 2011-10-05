package org.bandhu.core;

import java.io.Serializable;

import org.bandhu.core.rest.BandhuRESTService;
import org.bandhu.core.rpc.RPCService;
import org.bandhu.util.BandhuConfig;
import org.bandhu.util.BandhuException;

public abstract class ServiceAccessor implements Serializable {

    protected String id;
    protected Consumer consumer;
    protected boolean connected;
    private int serviceID;

    public ServiceAccessor(String id, Consumer consumer) throws BandhuException {
        chkConfig();

        if (id == null) {
            this.id = consumer.getUserId();
        } else {
            this.id = id;
        }
        this.consumer = consumer;
        this.serviceID = BandhuConfig.resolveToId(this.getClass());
    }

    private void chkConfig() throws BandhuException {
        if (!BandhuConfig.isConfigured()) {
            System.out.println("Bandhu's mandatory configs are missing!!");
            throw new BandhuException(
                    "Bandhu's mandatory configs are missing!!");
        }
    }

    public ServiceAccessor(Consumer consumer) throws BandhuException {
        this.id = String.valueOf(System.currentTimeMillis());
        this.consumer = consumer;
        this.serviceID = BandhuConfig.resolveToId(this.getClass());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public boolean isREST() {
        return this instanceof BandhuRESTService;
    }

    public boolean isRPC() {
        return this instanceof RPCService;
    }

    public boolean isExternal() {
        return !(isREST() || isRPC());
    }

}
