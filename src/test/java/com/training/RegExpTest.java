package com.training;

import org.junit.Test;

import com.training.services.util.RegExp;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

public class RegExpTest {
	
	@Test
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
    
    @Test
    public void testFirstNameCyrSymbols() {
        String input = "¯ÿüó³";
        boolean isMatched;
        boolean expected = true;
        isMatched = Pattern.matches(RegExp.NAME_REGEXP, input);
        assertEquals(isMatched, expected);
    }
    
    @Test
    public void testFirstNameCyrOddSybolsSymbols() {
        String input = "Ñåðã³é!";
        boolean isMatched;
        boolean expected = false;
        isMatched = Pattern.matches(RegExp.NAME_REGEXP, input);
        assertEquals(isMatched, expected);
    }
    
    @Test
    public void testPhoneValid() {
        String input = "0933460203";
        boolean isMatched;
        boolean expected = true;
        isMatched = Pattern.matches(RegExp.CELL_PHONE_REGEXP, input);
        assertEquals(isMatched, expected);
    }
    
    @Test
    public void testPhoneBracesValid() {
        String input = "(093)3460203";
        boolean isMatched;
        boolean expected = true;
        isMatched = Pattern.matches(RegExp.CELL_PHONE_REGEXP, input);
        assertEquals(isMatched, expected);
    }
    
    @Test
    public void testPhoneLongValid() {
        String input = "+38(093)346-02-03";
        boolean isMatched;
        boolean expected = true;
        isMatched = Pattern.matches(RegExp.CELL_PHONE_REGEXP, input);
        assertEquals(isMatched, expected);
    }
    
    @Test
    public void testPhoneLongOddInvalid() {
        String input = "+38(093)346-02-033";
        boolean isMatched;
        boolean expected = false;
        isMatched = Pattern.matches(RegExp.CELL_PHONE_REGEXP, input);
        assertEquals(isMatched, expected);
    }
}
