package com.sortly.automation.assertionhandler;

import org.testng.asserts.SoftAssert;

import com.sortly.automation.reportconfig.ExtentReportManager;

public class Assertions extends ExtentReportManager {
	private static SoftAssert asrt = new SoftAssert();

	public static boolean assertEquals(String ErrorMessage, String actual, String expected) {
		if (actual.equals(expected)) {
			logPass("Actual And Expected Values Are Matching : Actual Text=\"" + actual + "\" and Expected text=\""
					+ expected + "\"");
			asrt.assertEquals(actual, expected);
		} else {
			logFail("Actual And Expected Values Are Not Matching : Actual Text=\"" + actual + "\" and Expected text=\""
					+ expected + "\"");
			asrt.assertEquals(actual, expected, ErrorMessage);

		}
		return (expected.equals(expected)) ? true : false;

	}

	public static boolean assertTrue(String ErrorMessage, String actual, String expected) {
		if (actual.equals(expected)) {
			logPass("Actual And Expected Values Are Matching : Actual Text=\"" + actual + "\" and Expected text=\""
					+ expected + "\"");
			asrt.assertTrue(actual.equals(expected));
		} else {
			logFail("Actual And Expected Values Are Not Matching : Actual Text=\"" + actual + "\" and Expected text=\""
					+ expected + "\"");
			asrt.assertTrue(expected.equals(expected));

		}
		return (expected.equals(expected)) ? true : false;

	}

	public static boolean assertTrue(String ErrorMessage, boolean isTrue) {
		if (isTrue) {
			logPass("Is Expected Equal To Actual?\"" + String.valueOf(isTrue) + "\"");
			asrt.assertEquals(ErrorMessage, isTrue);
		} else {
			logFail(ErrorMessage);
			asrt.assertEquals(ErrorMessage, "Is Expected Equal To Actual?\"" + String.valueOf(isTrue) + "\"");
		}
		return isTrue;

	}
}
