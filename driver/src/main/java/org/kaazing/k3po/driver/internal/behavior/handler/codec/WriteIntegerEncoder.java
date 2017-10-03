/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.k3po.driver.internal.behavior.handler.codec;

import static org.jboss.netty.buffer.ChannelBuffers.wrappedBuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.jboss.netty.buffer.ChannelBuffer;

public class WriteIntegerEncoder implements MessageEncoder {

    private final int value;

    public WriteIntegerEncoder(int value) {
        this.value = value;
    }

    @Override
    public ChannelBuffer encode(ByteOrder endian) {
        byte[] array = ByteBuffer.allocate(Integer.BYTES)
                                 .order(endian)
                                 .putInt(value)
                                 .array();
        return wrappedBuffer(array);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

}
