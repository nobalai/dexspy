package com.bowen.dex;

import java.nio.ByteBuffer;

public class U1 extends DexComponent {

    private byte value;
 
    @Override
    public void readContent(ByteBuffer byteBuffer) {
        value = byteBuffer.get();
    }
}
