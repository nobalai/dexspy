package com.bowen.dex;

public class U1 extends DexComponent {

    private byte value;
 
    @Override
    public void readContent(DexReader dexReader) {
        value = dexReader.getByteBuffer().get();
    }
}
