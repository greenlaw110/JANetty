package org.agilewiki.janetty;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.lpc.Request;

public class OutgoingRequest extends Request<Object, Com> {

    public final String sourceProtocolName;
    public final String destinationProtocolName;
    public final String destinationProtocolFactoryName;
    public final byte[] payload;

    /**
     * Sent to the actor on the remote system with the given destinationProtocolName.
     */
    public OutgoingRequest(String sourceProtocolName, String destinationProtocolName, byte[] payload) {
        this.sourceProtocolName = sourceProtocolName;
        this.destinationProtocolName = destinationProtocolName;
        this.destinationProtocolFactoryName = null;
        this.payload = payload;
    }

    /**
     * Sent to the actor on the remote system with the given destinationProtocolName, creating it as needed.
     */
    public OutgoingRequest(String sourceProtocolName, String destinationProtocolName,
                           String destinationProtocolFactoryName, byte[] payload) {
        this.sourceProtocolName = sourceProtocolName;
        this.destinationProtocolName = destinationProtocolName;
        this.destinationProtocolFactoryName = destinationProtocolFactoryName;
        this.payload = payload;
    }

    @Override
    public boolean isTargetType(Actor targetActor) {
        return targetActor instanceof Com;
    }

}
