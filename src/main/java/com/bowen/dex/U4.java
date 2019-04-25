package com.bowen.dex;

public class U4 extends DexComponent {

    private int value;

    @Override
    public void readContent(DexReader dexReader) {
        value = dexReader.getByteBuffer().getInt();
    }

    public int get() {
        return value;
    }
}
