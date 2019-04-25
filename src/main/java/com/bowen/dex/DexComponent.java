package com.bowen.dex;

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

    public void read(DexReader dexReader) {
        offset = dexReader.position();
        readContent(dexReader);
        length = dexReader.position() - offset;
    }

    public abstract void readContent(DexReader dexReader);
}
