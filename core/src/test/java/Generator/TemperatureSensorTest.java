package Generator;

import Main.SettingStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureSensorTest {
	private Sensor testObject;

	@BeforeEach
	void setUp() {
		testObject = new TemperatureSensor();
		testObject.setup(new RandomMock(), new RandomNoiseAlgorithmMock(), new SettingStore());
	}

	@Test
	void getData() {
		String expected = "currentValue:5.0,precision:0.5,measurementUnit:°F";
		SensorData result = testObject.getData();
 		assertEquals(expected, result.toString());
	}

}