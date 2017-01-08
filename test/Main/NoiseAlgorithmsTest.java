package Main;

import Generator.NoiseAlgorithm;
import Generator.RandomNoiseAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 08/01/17.
 */
class NoiseAlgorithmsTest {
	@Test
	void getName() {
		String expected = "RandomNoiseAlgorithm";
		String result = NoiseAlgorithms.getName(NoiseAlgorithms.ALGORITHMS.RANDOM);
		assertEquals(expected, result);
	}

	@Test
	void getInstanceOf() {
		RandomNoiseAlgorithm expected = new RandomNoiseAlgorithm();
		NoiseAlgorithm result = null;
		try{
			result = NoiseAlgorithms.getInstanceOf(NoiseAlgorithms.ALGORITHMS.RANDOM);
		} catch (ReflectiveOperationException e) {
			System.out.println("Exception caught in NoiseAlgorithmsTest: " + e.getMessage());
			System.out.println("Trace: " + e.getStackTrace());
		}
		assertEquals(expected.getClass(), result.getClass());
	}

}