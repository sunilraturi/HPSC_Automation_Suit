package com.hpsc.qa.util;

import com.hpsc.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICT_WAIT = 30;

	public void swithToFrame() {
		driver.switchTo().frame(0);
	}
}
