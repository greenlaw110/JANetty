package org.agilewiki.janetty;

import org.agilewiki.jactor.Mailbox;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.jboss.netty.channel.Channel;

public class JACom extends JLPCActor implements Com {

    public Channel channel = null;

    public JACom(Mailbox mbox) {
        super(mbox);
    }

    @Override
    public void processRequest(OutgoingRequest outgoingRequest, RP<Object> rp)
            throws Exception {
        channel.write(outgoingRequest);
        rp.processResponse(null);
    }

}
