package Main;

import Generator.NoiseAlgorithm;
import Generator.RandomNoiseAlgorithm;

/**
 * Contains an enum of all possible NoiseAlgorithms. Used to create instances of NoiseAlgorithms.
 */
public class NoiseAlgorithmFactory {

	/**
	 * Returns an instance of the set NoiseAlgorithm.
	 * @param key The constant defining the NoiseAlgorithm.
	 * @return The NoiseAlgorithm object.
	 */
	public static NoiseAlgorithm createNoiseAlgorithm(ALGORITHMS key) {
		NoiseAlgorithm result = null;
		switch (key) {
			case RANDOM:
				result = new RandomNoiseAlgorithm();
				break;
			default:
				break;
		}
		return result;
	}

	/**
	 * The names of all implemented algorithms.
	 */
	public enum ALGORITHMS {
		RANDOM
	}

}
