package Output;

import Generator.SettingProvider;
import Main.SettingStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 03.01.17.
 */
class SimpleCounterTimestampTest {
	private SimpleCounterTimestamp testObject;

	@BeforeAll
	static void singleSetUp() {
		SettingProvider.set(new SettingStore());
	}

	@BeforeEach
	void setUp() {
		this.testObject = new SimpleCounterTimestamp();
	}

	@Test
	void getString() {
		String[] expectedResult = {"0000", "0001", "0002"};
		String[] actualResult = new String[3];
		for (int i = 0; i < 3; i++) {
			actualResult[i] = this.testObject.getString();
		}
		assertArrayEquals(expectedResult, actualResult);
	}

}