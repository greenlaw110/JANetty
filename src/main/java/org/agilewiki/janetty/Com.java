package org.agilewiki.janetty;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.TargetActor;

public interface Com extends TargetActor {
    public void processRequest(OutgoingRequest outgoingRequest, RP<Object> rp)
            throws Exception;
}
