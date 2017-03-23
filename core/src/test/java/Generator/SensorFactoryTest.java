package Generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SensorFactoryTest {

	@Test
	void createSensor() {
		TemperatureSensor expected = new TemperatureSensor();
		Sensor result;
		result = SensorFactory.createSensor(SensorFactory.TYPE.TEMPERATURE);
		assertEquals(expected.getClass(), result.getClass());
	}

}