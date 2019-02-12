package com.bowen.dex;

import java.nio.ByteBuffer;

public class U2 extends DexComponent {

    private short value;

    @Override
    public void readContent(ByteBuffer byteBuffer) {
        value = byteBuffer.getShort();
    }
}
