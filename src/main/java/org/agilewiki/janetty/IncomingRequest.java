package org.agilewiki.janetty;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.lpc.Request;

/**
 * A request from another JVM.
 */
public class IncomingRequest extends Request<Object, Protocol1> {

    public final String sourceHost;
    public final int SourcePort;
    public final String sourceProtocolName;
    public final byte[] payload;

    public IncomingRequest(String sourceHost, int SourcePort, String sourceProtocolName, byte[] payload) {
        this.sourceHost = sourceHost;
        this.SourcePort = SourcePort;
        this.sourceProtocolName = sourceProtocolName;
        this.payload = payload;
    }

    @Override
    public boolean isTargetType(Actor targetActor) {
        return targetActor instanceof Protocol1;
    }

}
