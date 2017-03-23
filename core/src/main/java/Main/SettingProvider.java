package Main;

import Generator.NoiseAlgorithm;

import java.util.Random;

/**
 * A singleton for settings retrieving. This object is used to access the settings and create the necessary objects. Complex global objects like the NoiseAlgorithm and the DataOutput are stored directly inside the SettingProvider object.
 */
public class SettingProvider {
	private static SettingProvider instance;
	private SettingStore settings;
	private DataOutput outputHandler;
	private NoiseAlgorithm noiseAlgorithm;
	private Random randomNumberGenerator;

	/**
	 * Private to restrict creation to the static methods.
	 */
	private SettingProvider() {}

	/**
	 * Returns the SettingProvider object.
	 * @return The object.
	 */
	public static SettingProvider get() {
		return instance;
	}

	/**
	 * Creates a new SettingProvider with the given settings.
	 * @param settings The settings object.
	 */
	public static void setSettingStore(SettingStore settings) {
		instance = new SettingProvider();
		instance.settings = settings;
	}

	/**
	 * Returns the SettingStore containing user-selected settings.
	 * @return The SettingStore object currently in use.
	 */
	public static SettingStore getSettingStore() {
		return instance.settings;
	}

	/**
	 * Creates the concrete, completely set up object of a subclass of NoiseAlgorithm if needed and returns it.
	 * @return The NoiseAlgorithm.
	 */
	public static NoiseAlgorithm getNoiseAlgorithm() {
		if (instance.noiseAlgorithm == null) {
			instance.noiseAlgorithm = NoiseAlgorithmFactory.createNoiseAlgorithm(instance.settings.getNoiseAlgorithm());
			instance.noiseAlgorithm.setup(instance.settings.getNoiseSettings());
		}
		return instance.noiseAlgorithm;
	}

	/**
	 * Can be used to set the noiseAlgorithm to be used in the generator. If it is not set this way it will be created on first retrieval.
	 * Should only be used for testing.
	 * @param noiseAlgorithm
	 */
	public static void setNoiseAlgorithm(NoiseAlgorithm noiseAlgorithm) {
		instance.noiseAlgorithm = noiseAlgorithm;
	}

	/**
	 * Returns the DataOutput that should receive the generated objects.
	 * @return The DataOutput handler.
	 */
	public static DataOutput getOutputHandler() {
		return instance.outputHandler;
	}

	/**
	 * Sets the DataOutput handler that should receive the generated objects.
	 * @param outputHandler
	 */
	public static void setOutputHandler(DataOutput outputHandler) {
		instance.outputHandler = outputHandler;
	}

	/**
	 * Returns the random number generator to be used. Creates a default Random object with the set seed if needed.
	 * @return Random
	 */
	public static Random getRandomNumberGenerator() {
		if (instance.randomNumberGenerator == null) {
			instance.randomNumberGenerator = new Random(instance.settings.getRandomNumberGeneratorSeed());
		}
		return instance.randomNumberGenerator;
	}

	/**
	 * Can be used to set the Random object to use in the generator. If its not set this way it will be created automatically on first retrieval.
	 * Should only be used for testing.
	 * @param rng The Random object to use.
	 */
	public static void setRandomNumberGenerator(Random rng) {
		instance.randomNumberGenerator = rng;
	}
}
