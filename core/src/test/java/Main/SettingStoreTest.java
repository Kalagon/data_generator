package Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingStoreTest {
	private SettingStore testObject;
	private int testInt = 6;
	private float testFloat = 3.5f;

	@BeforeEach
	void setUp() {
		this.testObject = new SettingStore();
	}

	@Test
	void setGetGeneratorSeed() {
		testObject.setRandomNumberGeneratorSeed(testInt);
		assertEquals(testInt, testObject.getRandomNumberGeneratorSeed());
	}

	@Test
	void setGetOutputSize() {
		testObject.setOutputSize(testInt);
		assertEquals(testInt, testObject.getOutputSize());
	}

	@Test
	void setGetNoiseAlgorithm() {
		assertEquals(NoiseAlgorithmFactory.ALGORITHMS.RANDOM, testObject.getNoiseAlgorithm());
	}


}