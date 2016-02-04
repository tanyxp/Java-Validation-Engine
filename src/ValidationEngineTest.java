import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidationEngineTest
{
	private IValidationEngine validator;
	
	@Before
	public void setUp()
	{
		validator = new ValidationEngine();
	}

	@Test
	public void moneyPassNotEmpty()
	{
		final String [] validationTags = new String[]{"money", "notEmpty", "notNegative"};
		final String value = "10.0103";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyFailEmpty()
	{
		final String [] validationTags = new String[]{"money", "notEmpty", "notNegative"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyFailNegative()
	{
		final String [] validationTags = new String[]{"money", "notEmpty", "notNegative"};
		final String value = "-10.0103";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorPasswithinModLimits()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "2.7";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorPassEqualLowerLimit()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "1.0";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorPassEqualUpperLimit()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "3.5";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailAboveLimit()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "3.55";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailBelowLimit()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "0.95";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailEmpty()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailNegative()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "-2.0";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void namePassValidFormat()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "Bob";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameFailnotAllAlpha()
	{
		final String [] validationTags = new String[]{"notEmpty", "firstLetterUpperOnly", "allAlpha"};
		final String value = "B2B";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameFailfirstLetterNotUpper()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "jAson";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameFailEmpty()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyNotEmptyMessage()
	{
		final String [] validationTags = new String[]{"money", "notEmpty", "notNegative"};
		final String value = "10.0103";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is valid";
		final String actual = validationResult.getMessage();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyEmptyMessage()
	{
		final String [] validationTags = new String[]{"money", "notEmpty", "notNegative"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value cannot be empty";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyNegativeMessage()
	{
		final String [] validationTags = new String[]{"money", "notEmpty", "notNegative"};
		final String value = "-10.0103";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is negative";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorwithinModLimitsMessage()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "2.7";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is valid";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorEqualLowerLimitMessage()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "1.0";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is valid";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorEqualUpperLimitMessage()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "3.5";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is valid";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorAboveLimitMessage()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "3.55";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is not within limits for a mod factor";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorBelowLimitMessage()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "0.95";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is not within limits for a mod factor";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorEmptyMessage()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "notNegative", "withinModLimits"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value cannot be empty";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorNegativeMessage()
	{
		final String [] validationTags = new String[]{"factor", "notEmpty", "withinModLimits", "notNegative"};
		final String value = "-2.0";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is negative";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameValidFormatMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "Bob";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is valid";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameNotAllAlphaMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "firstLetterUpperOnly", "allAlpha"};
		final String value = "B2B";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value has non alphabetic characters";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void namefirstLetterNotUpperMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "jAson";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value's first letter is not uppercase";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameEmptyMessage()
	{
		final String [] validationTags = new String[]{"allAlpha", "firstLetterUpperOnly", "notEmpty"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value cannot be empty";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
}
