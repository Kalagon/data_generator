package Main;

import Generator.NoiseAlgorithm;
import Generator.RandomNoiseAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoiseAlgorithmFactoryTest {

	@Test
	void createNoiseAlgorithm() {
		RandomNoiseAlgorithm expected = new RandomNoiseAlgorithm();
		NoiseAlgorithm result;
		result = NoiseAlgorithmFactory.createNoiseAlgorithm(NoiseAlgorithmFactory.ALGORITHMS.RANDOM);
		assertEquals(expected.getClass(), result.getClass());
	}

}