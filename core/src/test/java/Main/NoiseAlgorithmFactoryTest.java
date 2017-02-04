package Main;

import Generator.NoiseAlgorithm;
import Generator.RandomNoiseAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 08/01/17.
 */
class NoiseAlgorithmFactoryTest {

	@Test
	void getInstanceOf() {
		RandomNoiseAlgorithm expected = new RandomNoiseAlgorithm();
		NoiseAlgorithm result;
		result = NoiseAlgorithmFactory.getInstanceOf(NoiseAlgorithmFactory.ALGORITHMS.RANDOM);
		assertEquals(expected.getClass(), result.getClass());
	}

}