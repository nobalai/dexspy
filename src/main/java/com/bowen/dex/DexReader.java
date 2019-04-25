package com.bowen.dex;

import java.nio.ByteBuffer;

public class DexReader {

    private final ByteBuffer byteBuffer;

    public DexReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public int position() {
        return byteBuffer.position();
    }

    public ByteBuffer getByteBuffer() {
        return byteBuffer;
    }

    public U1 readU1() {
        U1 u1 = new U1();
        u1.read(this);
        return u1;
    }

    public U1[] readU1s(int length) {
        U1[] u1s = new U1[length];
        for (int i = 0; i < length; i++) {
            u1s[i] = readU1();
        }
        return u1s;
    }

    public U2 readU2() {
        U2 u2 = new U2();
        u2.read(this);
        return u2;
    }

    public U4 readU4() {
        U4 u4 = new U4();
        u4.read(this);
        return u4;
    }
}