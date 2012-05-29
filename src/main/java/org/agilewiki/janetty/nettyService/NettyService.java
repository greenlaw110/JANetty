package org.agilewiki.janetty.nettyService;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.TargetActor;
import org.agilewiki.janetty.Com;


public interface NettyService extends TargetActor {
    public void processRequest(CreateCom createCom, RP<Com> rp)
            throws Exception;

    public void close();

}
