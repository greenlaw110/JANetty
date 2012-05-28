package org.agilewiki.janetty.nettyService;

import org.agilewiki.jactor.Mailbox;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.janetty.Protocol1;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class JANettyService extends JLPCActor implements NettyService {

    private Protocol1 protocol1;
    private String remoteHost;
    private int remotePort;

    public static final Map<String, Object> DEFAULT_OPTIONS = Collections
            .unmodifiableMap(new HashMap<String, Object>() {
                public HashMap<String, Object> init() {
                    put("child.reuseAddress", true);
                    put("reuseAddress", true);
                    put("child.keepAlive", true);
                    put("child.connectTimeoutMillis", 100);
                    put("tcpNoDelay", true);
                    put("readWriteFair", true);
                    put("child.tcpNoDelay", true);
                    return this;
                }
            }.init());

    //public final NioServerSocketChannelFactory channelFactory;
    //public final ServerBootstrap server;

    public JANettyService(Mailbox mbox) {
        //this(port, DEFAULT_OPTIONS);
        super(mbox);
    }

    public void setProtocol1(Protocol1 protocol1) {
        if (this.protocol1 != null)
            throw new IllegalStateException("Attempt to change the protocol1 actor");
        this.protocol1 = protocol1;
    }

    public void setRemoteAddress(String remoteHost, int remotePort) {
        if (this.remoteHost != null)
            throw new IllegalStateException("remote host and port can not be changed");
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
    }

    public ServerBootstrap startServer(int port, Map<String, Object> options) {
        Executor boss = Executors.newSingleThreadExecutor();
        Executor worker = Executors.newSingleThreadExecutor();
        NioServerSocketChannelFactory channelFactory =
                new NioServerSocketChannelFactory(boss, worker);
        ChannelGroup channelGroup = new DefaultChannelGroup();

        ServerBootstrap server = new ServerBootstrap(channelFactory);
        server.setOptions(options);

        channelGroup.add(server.bind(new InetSocketAddress(port)));

        return server;
    }

    public void close() {
        // TODO
    }

    @Override
    protected void processRequest(Object request, RP rp) throws Exception {
        if (request instanceof CreateCom) {
            // TODO return a Com object via `rp`
        }
        throw new UnsupportedOperationException(request.getClass().getName());

    }

}
