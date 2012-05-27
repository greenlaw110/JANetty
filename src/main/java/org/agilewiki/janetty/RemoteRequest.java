package org.agilewiki.janetty;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.lpc.Request;

public class RemoteRequest extends Request<Object, RemoteRequestHandler> {
	
	public final String host;
	public final int    port;
	public final String source;
	public final String destination;
	public final byte[] payload;
	
	public RemoteRequest(String host, int port, String source, String destination, byte[] payload) {
		this.host = host;
		this.port = port;
		this.source = source;
		this.destination = destination;
		this.payload = payload;
	}

	@Override
	public boolean isTargetType(Actor targetActor) {
		return targetActor instanceof RemoteRequestHandler;
	}

}
