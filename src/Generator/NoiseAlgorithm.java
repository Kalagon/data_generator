package Generator;

import Main.NoiseSettingStore;

import java.io.Serializable;

/**
 * Base interface for all NoiseCalculators.
 */
public interface NoiseAlgorithm extends Serializable {
	/**
	 * Fills the blank object with the correct values based on the given settings.
	 * @param settings The requested settings.
	 */
	void setUp(NoiseSettingStore settings);

	/**
	 * Used to add noise to an integer value.
	 * @param inputValue The clean value.
	 * @return int
	 */
	int addNoise(int inputValue);

	/**
	 * Used to add noise inside a specified range to an integer value.
	 *
	 * @param inputValue The clean value.
	 * @param noiseRange The one-sided range for value changes.
	 * @return int
	 */
	int addNoise(int inputValue, int noiseRange);

	/**
	 * Used to add noise to a float value.
	 * @param inputValue The clean float value.
	 * @return float
	 */
	float addNoise(float inputValue);

	/**
	 * Used to add noise inside a specified range to a float value.
	 * @param inputValue The clean float value.
	 * @param noiseRange The one-sided range for value changes.
	 * @return float
	 */
	float addNoise(float inputValue, int noiseRange);
}
