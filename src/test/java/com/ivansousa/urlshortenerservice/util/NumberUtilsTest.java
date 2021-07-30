package com.ivansousa.urlshortenerservice.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberUtilsTest {
    @Test
    public void encodeToBase62_0_0() throws Exception {
        String base62 = NumberUtils.encodeToBase62(0L);

        assertEquals("0", base62);
    }

    @Test
    public void encodeToBase62_1_1() throws Exception {
        String base62 = NumberUtils.encodeToBase62(1L);

        assertEquals("1", base62);
    }

    @Test
    public void encodeToBase62_61_Z() throws Exception {
        String base62 = NumberUtils.encodeToBase62(61L);

        assertEquals("Z", base62);
    }

    @Test
    public void encodeToBase62_7433456763_8741FV() throws Exception {
        String base62 = NumberUtils.encodeToBase62(7433456763L);

        assertEquals("8741FV", base62);
    }

    @Test
    public void decodeFromBase62_0_0() throws Exception {
        Long num = NumberUtils.decodeFromBase62("0");

        assertEquals(0L, num);
    }

    @Test
    public void decodeFromBase62_1_1() throws Exception {
        Long num = NumberUtils.decodeFromBase62("1");

        assertEquals(1L, num);
    }

    @Test
    public void decodeFromBase62_Z_61() throws Exception {
        Long num = NumberUtils.decodeFromBase62("Z");

        assertEquals(61L, num);
    }

    @Test
    public void decodeFromBase62_8741FV_61() throws Exception {
        Long num = NumberUtils.decodeFromBase62("8741FV");

        assertEquals(7433456763L, num);
    }
}
