package org.agilewiki.janetty;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.TargetActor;

/**
 * Handles IncomingRequest's.
 */
public interface Protocol1 extends TargetActor {
    public void processRequest(IncomingRequest incomingRequest, RP<Object> rp)
            throws Exception;
}
