package Generator;

import Main.RandomNoiseSettingStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class RandomNoiseAlgorithmTest {
	private RandomNoiseAlgorithm testObject;
	private int inputInt = 13;
	private float inputFloat = 13.13f;

	@BeforeEach
	void setUp() {
		testObject = new RandomNoiseAlgorithm();
		RandomNoiseSettingStore settings = new RandomNoiseSettingStore(7685, 0.8f, 5);
		testObject.setup(settings);
	}

	@Test
	void addNoise() {
		int[] results = new int[3];
		for (int i = 0; i < 3; i++) {
			results[i] = testObject.addNoise(inputInt);
		}
		assertFalse(inputInt == results[0] && inputInt == results[1] && inputInt == results[2]);
	}

	@Test
	void addNoise1() {
		float[] results = new float[3];
		for (int i = 0; i < 3; i++) {
			results[i] = testObject.addNoise(inputFloat);
		}
		assertFalse(inputFloat == results[0] && inputFloat == results[1] && inputFloat == results[2]);
	}

}