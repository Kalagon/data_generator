package Generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 29.12.16.
 */
class TemperatureSensorFactoryTest {
	private TemperatureSensorFactory testObject;

	@BeforeEach
	void setUp() {
		testObject = new TemperatureSensorFactory();
	}

	@Test
	void createSensor() {
		TemperatureSensor expected = new TemperatureSensor(null);
		Sensor result = testObject.create(null);
		assertEquals(expected.getData().toString(), result.getData().toString());
	}

}