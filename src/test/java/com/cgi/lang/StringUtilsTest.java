package com.cgi.lang;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests for StringUtils lib
 */
public class StringUtilsTest {

    @Test
    public void testReverseStringWithSpaceDelimiters() throws Exception {
        String original = "vanitas vanitatum omnia vanitas";
        String result = StringUtils.reverseString(original);
        Assert.assertEquals("vanitas omnia vanitatum vanitas", result);
    }

    @Test
    public void testReverseStringWithMultipleSequentalSpaceDelimiters() throws Exception {
        String original = "vanitas vanitatum  omnia vanitas";
        String result = StringUtils.reverseString(original);
        Assert.assertEquals("vanitas  omnia vanitatum vanitas", result);
    }

    @Test
    public void testReverseStringWillNotChangeOriginalString() throws Exception {
        String original = "vanitas vanitatum omnia vanitas";
        StringUtils.reverseString(original);
        Assert.assertEquals("vanitas vanitatum omnia vanitas", original);

    }
}
