package Generator;

import Main.NoiseAlgorithms;
import Main.SettingStore;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A singleton for settings retrieving. This object is used to access the settings and create the necessary objects.
 */
public class SettingProvider {
	private static SettingProvider instance;
	private SettingStore settings;

	private SettingProvider() {}

	/**
	 * For use by set() only.
	 * @param settings The settings object.
	 */
	private SettingProvider(SettingStore settings) {
		this.settings = settings;
	}

	/**
	 * Creates a new SettingProvider with the given settings.
	 * @param settings The settings object.
	 */
	public static void set(SettingStore settings) {
		instance = new SettingProvider(settings);
	}

	/**
	 * Returns the SettingProvider object.
	 * @return The object.
	 */
	public static SettingProvider get() {
		return instance;
	}

	/**
	 * Returns the seed to use for the Random object in the Sensors.
	 * @return The seed.
	 */
	public int getGeneratorSeed() {
		return settings.getGeneratorSeed();
	}

	/**
	 * Returns the number of requested data sets.
	 * @return The output size.
	 */
	public long getOutputSize() {
		return settings.getOutputSize();
	}

	/**
	 * Returns the path to save the output to.
	 * @return The Path.
	 */
	public Path getFilePath() {
		return Paths.get(settings.getFileLocation());
	}

	/**
	 * Returns the size of the buffer.
	 * @return The buffer size.
	 */
	public int getBufferSize() {
		return settings.getBufferSize();
	}

	/**
	 * Creates the concrete object of a subclass of NoiseAlgorithm and returns it.
	 * @return The NoiseAlgorithm.
	 * @throws ReflectiveOperationException If the object cannot be instantiated.
	 */
	public NoiseAlgorithm getNoiseAlgorithm() throws ReflectiveOperationException {
		NoiseAlgorithm result = NoiseAlgorithms.getInstanceOf(this.settings.getNoiseAlgorithm());
		return result;
	}

}
