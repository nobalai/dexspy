package com.bowen.dex;

import java.nio.ByteBuffer;

public class DexFile {

    // header reference from
    // https://source.android.com/devices/tech/dalvik/dex-format#header-item
    final DexHeader dexHeader;

    public DexFile(ByteBuffer byteBuffer) {
        DexReader dexReader = new DexReader(byteBuffer);

        dexHeader = DexParser.getHeader(dexReader);
    }
}
