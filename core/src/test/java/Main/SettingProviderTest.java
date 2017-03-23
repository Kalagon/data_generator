package Main;

import Generator.NoiseAlgorithm;
import Generator.RandomNoiseAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingProviderTest {
	private SettingProvider testObject;

	@BeforeEach
	void setUp() {
		SettingStore settings = new SettingStore();
		SettingProvider.setSettingStore(settings);
		testObject = SettingProvider.get();
	}

	@Test
	void getGeneratorSeed() {
		int expected = 2345876;
		int result = SettingProvider.getSettingStore().getRandomNumberGeneratorSeed();
		assertEquals(expected, result);
	}

	@Test
	void getOutputSize() {
		long expected = 1000;
		long result = SettingProvider.getSettingStore().getOutputSize();
		assertEquals(expected, result);
	}

	@Test
	void getNoiseAlgorithm() {
		RandomNoiseAlgorithm expected = new RandomNoiseAlgorithm();
		NoiseAlgorithm result;
		result = SettingProvider.getNoiseAlgorithm();

		assertEquals(expected.getClass(), result.getClass());
	}

}