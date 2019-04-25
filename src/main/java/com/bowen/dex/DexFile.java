package com.bowen.dex;

import java.nio.ByteBuffer;

public class DexFile {

    // header reference from
    // https://source.android.com/devices/tech/dalvik/dex-format#header-item
    private final DexHeader dexHeader;
    private final StringIds stringIds;

    public DexFile(ByteBuffer byteBuffer) {
        DexReader dexReader = new DexReader(byteBuffer);

        dexHeader = DexParser.getHeader(dexReader);
        stringIds = DexParser.getStringIds(dexHeader, dexReader);
    }
}
