package Main;

/**
 * Stores all settings needed for a RandomNoiseAlgorithm.
 */
public class RandomNoiseSettingStore implements NoiseSettingStore {
	private int seed;
	private float noiseFactor;

	public RandomNoiseSettingStore(int seed, float noiseFactor) {
		this.seed = seed;
		this.noiseFactor = noiseFactor;
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

	public void setNoiseFactor(float noiseFactor) {
		this.noiseFactor = noiseFactor;
	}
}
