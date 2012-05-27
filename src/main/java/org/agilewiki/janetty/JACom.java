package org.agilewiki.janetty;

import java.util.Map;

import org.agilewiki.jactor.Mailbox;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.pubsub.actorName.JActorName;
import org.jboss.netty.channel.Channel;

public class JACom extends JLPCActor implements Com {
	
	public Channel channel = null;
	
	public Map<String, JActorName> PROTOCOL_REGISTRY = null;
	
	public JACom(Mailbox mbox) {
		super(mbox);
	}

	@Override
	protected void processRequest(Object request, RP rp) throws Exception {
		Class reqClass = request.getClass();
		if (RemoteRequest.class.isAssignableFrom(reqClass)) {
			remoteRequest((RemoteRequest) request);
			rp.processResponse(null);
			return;
		}
		throw new UnsupportedOperationException(reqClass.getName());
	}
	
	protected void remoteRequest(RemoteRequest req) {
		channel.write(req);
	}

}
