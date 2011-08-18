package org.bandhu.core;

public abstract class ServiceAccessor {

    protected String id;
    protected Consumer consumer;
    protected boolean connected;

    public ServiceAccessor(String id, Consumer consumer) {
        if (id == null) {
            this.id = consumer.getUserId();
        } else {
            this.id = id;
        }
        this.consumer = consumer;
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
}
