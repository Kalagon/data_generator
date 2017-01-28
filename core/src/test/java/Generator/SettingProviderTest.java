package Generator;

import Main.SettingStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 04.01.17.
 */
class SettingProviderTest {
	private SettingProvider testObject;

	@BeforeEach
	void setUp() {
		SettingStore settings = new SettingStore();
		SettingProvider.set(settings);
		testObject = SettingProvider.get();
	}

	@Test
	void getGeneratorSeed() {
		int expected = 2345876;
		int result = SettingProvider.get().getGeneratorSeed();
		assertEquals(expected, result);
	}

	@Test
	void getOutputSize() {
		long expected = 1000;
		long result = SettingProvider.get().getOutputSize();
		assertEquals(expected, result);
	}

	@Test
	void getFilePath() {
		Path expected = Paths.get("output.txt");
		Path result = SettingProvider.get().getFilePath();
		assertEquals(expected, result);
	}

	@Test
	void getBufferSize() {
		int expected = 100;
		int result = SettingProvider.get().getBufferSize();
		assertEquals(expected, result);
	}

	@Test
	void getNoiseAlgorithm() {
		RandomNoiseAlgorithm expected = new RandomNoiseAlgorithm();
		NoiseAlgorithm result = null;
		try {
			result = SettingProvider.get().getNoiseAlgorithm();
		} catch(ReflectiveOperationException e) {
		}
		assertEquals(expected.getClass(), result.getClass());
	}

}