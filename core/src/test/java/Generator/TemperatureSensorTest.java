package Generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 29.12.16.
 */
class TemperatureSensorTest {
	private TemperatureSensor testObject;

	@BeforeEach
	void setUp() {
		testObject = new TemperatureSensor(null);
	}

	@Test
	void getData() {
		SensorData result = testObject.getData();
		assertTrue(result instanceof SensorData);
	}

}