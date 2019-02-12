package com.bowen.dex;

import java.nio.ByteBuffer;

public abstract class DexComponent {

    private int offset;
    private int length;

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    public void read(ByteBuffer byteBuffer) {
        offset = byteBuffer.position();
        readContent(byteBuffer);
        length = byteBuffer.position() - offset;
    }

    public abstract void readContent(ByteBuffer byteBuffer);
}
