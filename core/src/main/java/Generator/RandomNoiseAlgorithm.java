package Generator;

import Main.NoiseSettingStore;
import Main.RandomNoiseSettingStore;

import java.util.Random;

/**
 * Adds random noise based on a user-defined factor.
 */
public class RandomNoiseAlgorithm implements NoiseAlgorithm {
	private Random rng;
	private float noiseFactor;
	private int defaultRange = 5;

	/**
	 * Fills the blank object with the correct values based on the given settings. The NoiseSettingStore is casted to a RandomNoiseSettingStore without checking. It must be ensured that settings is an instance of RandomNoiseSettingStore beforehand.
	 *
	 * @param settings The requested settings.
	 */
	@Override
	public void setUp(NoiseSettingStore settings) {
		assert(settings instanceof RandomNoiseSettingStore); //TODO: remove once the check is implemented
		RandomNoiseSettingStore tmpSettings = (RandomNoiseSettingStore) settings;
		this.rng = new Random(tmpSettings.getSeed());
		this.noiseFactor = tmpSettings.getNoiseFactor();
	}

	/**
	 * Used to add noise to an integer value. Uses the default range.
	 *
	 * @param inputValue The clean value.
	 * @return int
	 */
	@Override
	public int addNoise(int inputValue) {
		return addNoise(inputValue, defaultRange);
	}

	/**
	 * Used to add noise inside a specified range to an integer value.
	 *
	 * @param inputValue The clean value.
	 * @param noiseRange The one-sided range for value changes.
	 * @return int
	 */
	@Override
	public int addNoise(int inputValue, int noiseRange) {
		int result = inputValue;
		boolean applyNoise = (rng.nextFloat() <= noiseFactor);
		if (applyNoise) {
			int noiseValue = rng.nextInt(noiseRange);
			result = (rng.nextBoolean() ? inputValue + noiseValue : inputValue - noiseValue);
		}
		return result;
	}

	/**
	 * Used to add noise to a float value. Uses the default Range.
	 *
	 * @param inputValue The clean float value.
	 * @return float
	 */
	@Override
	public float addNoise(float inputValue) {
		return addNoise(inputValue, defaultRange);
	}

	/**
	 * Used to add noise inside a specified range to a float value.
	 *
	 * @param inputValue The clean float value.
	 * @param noiseRange The one-sided range for value changes.
	 * @return float
	 */
	@Override
	public float addNoise(float inputValue, int noiseRange) {
		float result = inputValue;
		boolean applyNoise = (rng.nextFloat() <= noiseFactor);
		if (applyNoise) {
			float noiseValue = rng.nextInt(noiseRange) + rng.nextFloat();
			result = (rng.nextBoolean() ? inputValue + noiseValue : inputValue - noiseValue);
		}
		return result;
	}
}
