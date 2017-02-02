package Generator;

import Main.SettingProvider;
import Main.SettingStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 02/02/17.
 */
public class TemperatureDataSupplierTest {
	private Sensor testObject;

	@BeforeAll
	static void setUpOnce() {
		SettingProvider.setSettingStore(new SettingStore());
	}

	@BeforeEach
	void setUp() {
		testObject = new Sensor(new RandomMock(), new RandomNoiseAlgorithmMock(), Sensor.TYPE.TEMPERATURE);
	}

	@Test
	public void get() {
		String expected = "currentValue:5.0,precision:0.5,measurementUnit:°F";
		SensorData result = this.testObject.getData();
		assertEquals(expected, result.toString());
	}

}

class RandomMock extends Random {
	@Override
	public int nextInt(int input) {
		return 10;
	}

	@Override
	public float nextFloat() {
		return 0f;
	}

	@Override
	public boolean nextBoolean() {
		return true;
	}
}

class RandomNoiseAlgorithmMock extends RandomNoiseAlgorithm {
	@Override
	public float addNoise(float input) {
		return input;
	}
}