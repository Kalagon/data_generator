package Generator;

import Main.SettingStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 15/01/17.
 */
class DataOutputBufferTest {

	@BeforeAll
	static void setUp() {
		SettingProvider.set(new SettingStore());
	}

	@Test
	void append() {
		DataOutputBuffer testObject = new DataOutputBuffer();
		testObject.append(new SensorData(0.3f, 0.5f, "C"));
	}

	@Test
	void notFull() {
		DataOutputBuffer testObject = new DataOutputBuffer(2);
		testObject.append(new SensorData(0.3f, 0.5f, "C"));
		boolean result1 = testObject.notFull();
		testObject.append(new SensorData(0.2f, 0.5f, "C"));
		boolean result2 = testObject.notFull();
		assertTrue(result1);
		assertFalse(result2);
	}

	@Test
	void getContents() {

	}

}