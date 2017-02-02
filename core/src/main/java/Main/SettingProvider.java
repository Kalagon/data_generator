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

	/**
	 * Private to restrict creation to the static methods.
	 */
	private SettingProvider() {}

	/**
	 * For use by setSettingStore() only.
	 * @param settings The settings object.
	 */
	private SettingProvider(SettingStore settings) {
		this.settings = settings;
	}

	/**
	 * Returns the SettingProvider object.
	 * @return The object.
	 */
	public static SettingProvider get() {
		return instance;
	}

	/**
	 * Creates a new SettingProvider with the given settings. This can only be done once. On consequent calls it will silently fail.
	 * @param settings The settings object.
	 */
	public static void setSettingStore(SettingStore settings) {
		if (instance == null) {
			instance = new SettingProvider(settings);
		}
	}

	/**
	 * Returns the SettingStore containing user-selected settings.
	 * @return The SettingStore object currently in use.
	 */
	public static SettingStore getSettingStore() {
		return instance.settings;
	}

	/**
	 * Creates the concrete object of a subclass of NoiseAlgorithm if needed and returns it.
	 * @return The NoiseAlgorithm.
	 */
	public static NoiseAlgorithm getNoiseAlgorithm() {
		if (instance.noiseAlgorithm == null) {
			instance.noiseAlgorithm = NoiseAlgorithmFactory.getInstanceOf(instance.settings.getNoiseAlgorithm());
		}
		return instance.noiseAlgorithm;
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
}
