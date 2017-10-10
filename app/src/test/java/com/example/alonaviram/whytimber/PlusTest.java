package com.example.alonaviram.whytimber;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alonaviram on 27/09/2017.
 */
public class PlusTest {

    @Test
    public void testPlus() throws Exception {
        Plus plus = new Plus(5, 3);
        int result = plus.result();
        Assert.assertEquals(result, 8);
    }
}