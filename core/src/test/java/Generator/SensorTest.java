package Generator;

import Main.RandomNoiseSettingStore;
import Main.SettingProvider;
import Main.SettingStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 29.12.16.
 */
class SensorTest {
	private Sensor testObject;

	@BeforeAll
	static void setUpOnce() {
		SettingProvider.setSettingStore(new SettingStore());
	}

	@BeforeEach
	void setUp() {
		RandomNoiseAlgorithm noiseAlgorithm = new RandomNoiseAlgorithm();
		noiseAlgorithm.setUp(new RandomNoiseSettingStore());
		testObject = new Sensor(new Random(), noiseAlgorithm, Sensor.TYPE.TEMPERATURE);
	}

	@Test
	void getData() {
		SensorData result = testObject.getData();
		assertTrue(result != null);
	}

}