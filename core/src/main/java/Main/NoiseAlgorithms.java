package Main;

import Generator.NoiseAlgorithm;

import java.util.HashMap;

/**
 * Contains all possible NoiseAlgorithms. Provides tools for listing and checking.
 */
public class NoiseAlgorithms {

	/**
	 * The names of all implemented algorithms.
	 */
	public enum ALGORITHMS {
		RANDOM
	}

	/**
	 * Maps the constants to the class names.
	 */
	private static final HashMap<ALGORITHMS, String> NAMES;
	static {
		HashMap<ALGORITHMS, String> tmp = new HashMap<>();
		tmp.put(ALGORITHMS.RANDOM, "RandomNoiseAlgorithm");
		NAMES = tmp;
	}

	/**
	 * The package name.
	 */
	private static final String PREFIX = "Generator.";

	/**
	 * Returns the name of the class  belonging to the given algorithm.
	 * @param key The constant defining the NoiseAlgorithm.
	 * @return The name of the class.
	 */
	public static String getName(ALGORITHMS key) {
		return NAMES.get(key);
	}

	/**
	 * Returns an instance of the set NoiseAlgorithm. Uses reflection.
	 * @param key The constant defining the NoiseAlgorithm.
	 * @return The NoiseAlgorithm object.
	 * @throws ReflectiveOperationException If the class cannot be found, cast or created.
	 */
	public static NoiseAlgorithm getInstanceOf(ALGORITHMS key) throws ReflectiveOperationException {
		String className = PREFIX + getName(key);
		Class<?> cls = Class.forName(className);
		return (NoiseAlgorithm) cls.getConstructor().newInstance();
	}

}
