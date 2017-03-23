package Main;

import java.io.Serializable;

/**
 * Stores all settings needed for a RandomNoiseAlgorithm.
 */
public class RandomNoiseSettingStore implements NoiseSettingStore, Serializable {
	private int seed;
	private float noiseFactor;
	private int range;

	public RandomNoiseSettingStore() {
		this.seed = 98653489;
		this.noiseFactor = 0.5f;
		this.range = 5;
	}

	public RandomNoiseSettingStore(int seed, float noiseFactor, int range) {
		this.seed = seed;
		this.noiseFactor = noiseFactor;
		this.range = range;
	}

	public int getSeed() {
		return this.seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public float getNoiseFactor() {
		return noiseFactor;
	}

	/**
	 * Sets the noiseFactor. The value will be constrained to the range [0,1].
	 * @param noiseFactor
	 */
	public void setNoiseFactor(float noiseFactor) {
		this.noiseFactor = constrainNoiseFactor(noiseFactor);
	}

	/**
	 * Constrains the input value to [0,1];
	 * @param noiseFactor
	 * @return 0 if noiseFactor < 0; 1 if noiseFactor > 1; noiseFactor else
	 */
	private float constrainNoiseFactor(float noiseFactor) {
		if (noiseFactor > 1) {
			noiseFactor = 1;
		} else if (noiseFactor < 0) {
			noiseFactor = 0;
		}
		return noiseFactor;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
}
