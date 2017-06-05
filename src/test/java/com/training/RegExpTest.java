package com.training;

import org.junit.Test;

import com.training.services.util.RegExp;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

public class RegExpTest {
	public void testFirstNameNormal() {
        String input = "Alex";
        boolean isMatched;
        boolean expected = true;
        isMatched = Pattern.matches(RegExp.NAME_REGEXP, input);
        assertEquals(isMatched, expected);
    }

    @Test
    public void testFirstNameLowercase() {
        String input = "alex";
        boolean isMatched;
        boolean expected = false;
        isMatched = Pattern.matches(RegExp.NAME_REGEXP, input);
        assertEquals(isMatched, expected);
    }

    @Test
    public void testFirstNameUnexpectedSymbols() {
        String input = "Al3ex";
        boolean isMatched;
        boolean expected = false;
        isMatched = Pattern.matches(RegExp.NAME_REGEXP, input);
        assertEquals(isMatched, expected);
    }
}
