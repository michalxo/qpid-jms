/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.qpid.jms.transports.netty;

import java.net.URI;

import org.apache.qpid.jms.transports.Transport;
import org.apache.qpid.jms.transports.TransportListener;
import org.apache.qpid.jms.transports.TransportOptions;

/**
 * Test the Netty based WebSocket Transport
 */
public class NettyWsTransportTest extends NettyTcpTransportTest {

    @Override
    protected NettyEchoServer createEchoServer(TransportOptions options, boolean needClientAuth) {
        return new NettyEchoServer(options, needClientAuth, true);
    }

    @Override
    protected Transport createTransport(URI serverLocation, TransportListener listener, TransportOptions options) {
        if (listener == null) {
            return new NettyWsTransport(serverLocation, options);
        } else {
            return new NettyWsTransport(listener, serverLocation, options);
        }
    }
}
