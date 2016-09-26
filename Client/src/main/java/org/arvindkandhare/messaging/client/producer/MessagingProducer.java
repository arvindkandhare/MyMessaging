package org.arvindkandhare.messaging.client.producer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;

import javax.net.ssl.SSLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 * Created by kandha on 9/25/16.
 */
public class MessagingProducer<K,V> implements Producer<K, V> {
    private final String hostName;
    private final int port;
    private boolean SSL = false;

    public MessagingProducer(String hostName, int port) throws SSLException, InterruptedException {
        this.hostName = hostName;
        this.port     = port;
        setupConnection();

    }

    private void setupConnection() throws SSLException, InterruptedException {
        // Configure SSL.git
        final SslContext sslCtx;
        if (SSL) {
            sslCtx = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslCtx = null;
        }

        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            if (sslCtx != null) {
                                p.addLast(sslCtx.newHandler(ch.alloc(), hostName, port));
                            }
                            //p.addLast(new LoggingHandler(LogLevel.INFO));
                            p.addLast(new MessagingClientHandler());
                        }
                    });

            // Start the client.
            ChannelFuture f = b.connect(hostName, port).sync();

            // Wait until the connection is closed.
            //f.channel().closeFuture().sync();
        } finally {
            // Shut down the event loop to terminate all threads.
            //group.shutdownGracefully();
        }
    }

    public Future<RecordMetadata> send(ProducerRecord<K, V> record) {
        return null;
    }

    public Future<RecordMetadata> send(ProducerRecord<K, V> record, Callback callback) {
        return null;
    }

    public void flush() {

    }

    public List<PartitionInfo> partitionsFor(String topic) {
        return null;
    }

    public Map<MetricName, ? extends Metric> metrics() {
        return null;
    }

    public void close() {

    }

    public void close(long timeout, TimeUnit unit) {

    }
}
