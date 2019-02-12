package com.bowen.dex;

import java.nio.ByteBuffer;

public class U4 extends DexComponent {

    private int value;

    @Override
    public void readContent(ByteBuffer byteBuffer) {
        value = byteBuffer.getInt();
    }
}
