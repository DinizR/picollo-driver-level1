/*
* EndPoint.java
 */
package org.picollo.backend.model;

import java.util.Map;

public abstract class EndPoint {
    private String name;
    private ProtocolType protocol;
    private String host;
    private int port;
    private int timeout;
    private EndPoint healthCheckEndpoint;
    private ProtocolType healthCheckProtocol;
    private int unHealthThreshold;
    private int healthThreshold;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getUnHealthThreshold() {
        return unHealthThreshold;
    }

    public void setUnHealthThreshold(int unHealthThreshold) {
        this.unHealthThreshold = unHealthThreshold;
    }

    public int getHealthThreshold() {
        return healthThreshold;
    }

    public void setHealthThreshold(int healthThreshold) {
        this.healthThreshold = healthThreshold;
    }

    public ProtocolType getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolType protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public EndPoint getHealthCheckEndpoint() {
        return healthCheckEndpoint;
    }

    public void setHealthCheckEndpoint(EndPoint healthCheckEndpoint) {
        this.healthCheckEndpoint = healthCheckEndpoint;
    }

    public ProtocolType getHealthCheckProtocol() {
        return healthCheckProtocol;
    }

    public void setHealthCheckProtocol(ProtocolType healthCheckProtocol) {
        this.healthCheckProtocol = healthCheckProtocol;
    }

    protected abstract String call(Map params);
    protected abstract boolean checkParams(Map params);

    @Override
    public String toString() {
        return "EndPoint{" +
                "name='" + name + '\'' +
                ", protocol='" + protocol + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", timeout=" + timeout +
                ", healthCheckEndpoint=" + healthCheckEndpoint +
                ", healthCheckProtocol=" + healthCheckProtocol +
                ", unHealthThreshold=" + unHealthThreshold +
                ", healthThreshold=" + healthThreshold +
                '}';
    }
}
