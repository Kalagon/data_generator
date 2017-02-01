package Generator;

import Main.SettingProvider;
import Main.SettingStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 29.12.16.
 */
class SensorTest {
	private Sensor testObject;

	@BeforeAll
	static void setUpOnce() {
		SettingProvider.set(new SettingStore());
	}

	@BeforeEach
	void setUp() {
		testObject = new Sensor(null, null, Sensor.TYPE.TEMPERATURE);
	}

	@Test
	void getData() {
		SensorData result = testObject.getData();
		assertTrue(result instanceof SensorData);
	}

}