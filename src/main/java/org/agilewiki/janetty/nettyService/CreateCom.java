package org.agilewiki.janetty.nettyService;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.lpc.Request;
import org.agilewiki.janetty.Com;

/**
 * Request an existing Com actor, or create a new one.
 */
public class CreateCom extends Request<Com, NettyService> {
	
	public final String host;
	public final int port;
	
	public CreateCom(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	@Override
	public boolean isTargetType(Actor targetActor) {
		return targetActor instanceof NettyService;
	}

}
