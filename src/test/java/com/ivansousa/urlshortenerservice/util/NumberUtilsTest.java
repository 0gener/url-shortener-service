package com.ivansousa.urlshortenerservice.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberUtilsTest {
    @Test
    public void encode_0_0() throws Exception {
        String base62 = Base62Utils.encode(0L);

        assertEquals("0", base62);
    }

    @Test
    public void encode_1_1() throws Exception {
        String base62 = Base62Utils.encode(1L);

        assertEquals("1", base62);
    }

    @Test
    public void encode_61_Z() throws Exception {
        String base62 = Base62Utils.encode(61L);

        assertEquals("Z", base62);
    }

    @Test
    public void encode_7433456763_8741FV() throws Exception {
        String base62 = Base62Utils.encode(7433456763L);

        assertEquals("8741FV", base62);
    }

    @Test
    public void decode_0_0() throws Exception {
        Long num = Base62Utils.decode("0");

        assertEquals(0L, num);
    }

    @Test
    public void decode_1_1() throws Exception {
        Long num = Base62Utils.decode("1");

        assertEquals(1L, num);
    }

    @Test
    public void decode_Z_61() throws Exception {
        Long num = Base62Utils.decode("Z");

        assertEquals(61L, num);
    }

    @Test
    public void decode_8741FV_61() throws Exception {
        Long num = Base62Utils.decode("8741FV");

        assertEquals(7433456763L, num);
    }
}
