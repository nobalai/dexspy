package com.bowen.dex;

public class U2 extends DexComponent {

    private short value;

    @Override
    public void readContent(DexReader dexReader) {
        value = dexReader.getByteBuffer().getShort();
    }

    public short get() {
        return value;
    }
}
