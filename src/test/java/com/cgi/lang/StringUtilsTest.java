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
    public void testReverseStringWithNoDelimiter() throws Exception {
        String original = "vanitasvanitatumomniavanitas";
        String result = StringUtils.reverseString(original);
        Assert.assertEquals("vanitasvanitatumomniavanitas", result);
    }


    @Test
    public void testReverseStringWithMultipleSequentalSpaceDelimiters() throws Exception {
        String original = "vanitas vanitatum omnia    vanitas";
        String result = StringUtils.reverseString(original);
        Assert.assertEquals("vanitas omnia vanitatum    vanitas", result);
    }

    @Test
    public void testReverseStringWillNotChangeOriginalString() throws Exception {
        String original = "vanitas vanitatum omnia vanitas";
        StringUtils.reverseString(original);
        Assert.assertEquals("vanitas vanitatum omnia vanitas", original);

    }

    @Test
    public void testReverseNullString() throws Exception {
        Assert.assertNull(StringUtils.reverseString(null));
    }

    @Test
    public void testReverseEmtpyString() throws Exception {
        Assert.assertEquals("", StringUtils.reverseString(""));
    }

    @Test
    public void testReverseStringWithDelimiterAsLast() throws Exception {
        String original = "vanitas vanitatum omnia vanitas ";
        String result = StringUtils.reverseString(original);
        Assert.assertEquals("vanitas omnia vanitatum vanitas ", result);
    }

    @Test
    public void testReverseStringWithDelimiterAsFirst() throws Exception {
        String original = " vanitas vanitatum omnia vanitas";
        String result = StringUtils.reverseString(original);
        Assert.assertEquals(" vanitas omnia vanitatum vanitas", result);
    }

    @Test
    public void testReverseStringWithDelimiterAsRegularExpression() throws Exception {
        String original = "_*a_*_*b";
        String result = StringUtils.reverseString(original, "_*");
        Assert.assertEquals("_*b_*_*a", result);
    }

}
