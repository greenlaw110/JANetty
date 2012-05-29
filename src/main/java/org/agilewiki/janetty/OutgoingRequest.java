package org.agilewiki.janetty;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;
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

    @Override
    public void processRequest(JLPCActor targetActor, RP rp) throws Exception {
        Com com = (Com) targetActor;
        com.processRequest(this, rp);
    }
}
