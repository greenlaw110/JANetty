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
    protected void processRequest(Object request, RP rp) throws Exception {
        Class reqClass = request.getClass();
        if (OutgoingRequest.class.isAssignableFrom(reqClass)) {
            remoteRequest((OutgoingRequest) request);
            rp.processResponse(null);
            return;
        }
        throw new UnsupportedOperationException(reqClass.getName());
    }

    protected void remoteRequest(OutgoingRequest req) {
        channel.write(req);
    }

}
