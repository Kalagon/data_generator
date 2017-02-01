package Main;

import Generator.DataOutput;
import Generator.NoiseAlgorithm;

/**
 * A singleton for settings retrieving. This object is used to access the settings and create the necessary objects. Complex global objects like the NoiseAlgorithm and the DataOutput are stored directly inside the SettingProvider object.
 */
public class SettingProvider {
	private static SettingProvider instance;
	private SettingStore settings;
	private DataOutput outputHandler;
	private NoiseAlgorithm noiseAlgorithm;

	private SettingProvider() {}

	/**
	 * For use by set() only.
	 * @param settings The settings object.
	 */
	private SettingProvider(SettingStore settings) {
		this.settings = settings;
	}

	/**
	 * Creates a new SettingProvider with the given settings. This can only be done once. On consequent calls it will silently fail.
	 * @param settings The settings object.
	 */
	public static void set(SettingStore settings) {
		if (instance == null) {
			instance = new SettingProvider(settings);
		}
	}

	/**
	 * Returns the SettingProvider object.
	 * @return The object.
	 */
	public static SettingProvider get() {
		return instance;
	}

	/**
	 * Returns the SettingStore containing user-selected settings.
	 * @return The SettingStore object currently in use.
	 */
	public static SettingStore getSettingStore() {
		return instance.settings;
	}

	/**
	 * Creates the concrete object of a subclass of NoiseAlgorithm if needed and returns it. Terminates the program with code 2 if the NoiseAlgorithm cannot be created.
	 * @return The NoiseAlgorithm.
	 */
	public static NoiseAlgorithm getNoiseAlgorithm() {
		if (instance.noiseAlgorithm == null) {
			try {
				instance.noiseAlgorithm = NoiseAlgorithmFactory.getInstanceOf(instance.settings.getNoiseAlgorithm());
			} catch (ReflectiveOperationException e) {
				System.exit(2);
			}
		}
		return instance.noiseAlgorithm;
	}

	public static DataOutput getOutputHandler() {
		return instance.outputHandler;
	}

	public static void setOutputHandler(DataOutput outputHandler) {
		instance.outputHandler = outputHandler;
	}
}
