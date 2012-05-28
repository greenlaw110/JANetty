package org.agilewiki.janetty;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.lpc.Request;

public class OutgoingRequest extends Request<Object, Com> {

    public final byte[] payload;

    /**
     * Sent to the actor on the remote system with the given destinationProtocolName.
     */
    public OutgoingRequest(byte[] payload) {
        this.payload = payload;
    }

    @Override
    public boolean isTargetType(Actor targetActor) {
        return targetActor instanceof Com;
    }

}
