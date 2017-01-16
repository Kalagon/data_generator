package Main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * An Object of this class contains all user-selectable settings. This is used to initialize the generator.
 */
public class SettingStore {
	private int generatorSeed;
	private long outputSize;
	private String fileLocation;
	private int bufferSize;
	private NoiseAlgorithms.ALGORITHMS noiseAlgorithm;
	private NoiseSettingStore noiseSettings;

	/**
	 * Initializes the object with default values.
	 */
	public SettingStore() {
		this.generatorSeed = 2345876;
		this.outputSize = 1000;
		this.fileLocation = "output.txt";
		this.bufferSize = 100;
		this.noiseAlgorithm = NoiseAlgorithms.ALGORITHMS.RANDOM;
		this.noiseSettings = new RandomNoiseSettingStore(98653489, 0.5f);
	}

	public SettingStore(int generatorSeed, int outputSize, String fileLocation, int bufferSize, NoiseAlgorithms.ALGORITHMS noiseAlgorithm, NoiseSettingStore noiseSettings) throws InvalidSettingException {
		this.setGeneratorSeed(generatorSeed);
		this.setOutputSize(outputSize);
		this.setFileLocation(fileLocation);
		this.setBufferSize(bufferSize);
		this.setNoiseAlgorithm(noiseAlgorithm);
		this.setNoiseSettings(noiseSettings);
	}

	public int getGeneratorSeed() {
		return generatorSeed;
	}

	public void setGeneratorSeed(int generatorSeed) {
		this.generatorSeed = generatorSeed;
	}

	public long getOutputSize() {
		return outputSize;
	}

	public void setOutputSize(long outputSize) {
		this.outputSize = outputSize;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	/**
	 * Sets the file to write output to if possible.
	 *
	 * @param fileLocation The file to write to.
	 * @throws InvalidSettingException If the location is not accessible or the file is not writable.
	 */
	public void setFileLocation(String fileLocation) throws InvalidSettingException {
		if (pathIsAvailable(fileLocation)) {
			this.fileLocation = fileLocation;
		} else {
			throw new InvalidSettingException("The file location is invalid or the file is not writable.", "invalidFileLocation");
		}
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		if (bufferSize < 0) {
			bufferSize = 0;
		}
		this.bufferSize = bufferSize;
	}

	public NoiseAlgorithms.ALGORITHMS getNoiseAlgorithm() {
		return noiseAlgorithm;
	}

	public void setNoiseAlgorithm(NoiseAlgorithms.ALGORITHMS noiseAlgorithm) {
		this.noiseAlgorithm = noiseAlgorithm;
	}

	public NoiseSettingStore getNoiseSettings() {
		return noiseSettings;
	}

	public void setNoiseSettings(NoiseSettingStore noiseSettings) {
		this.noiseSettings = noiseSettings;
	}

	/**
	 * Checks if a path is accessible to the program.
	 *
	 * @param fileLocation The path to check.
	 * @return True if file exists and is writable or file does not exist yet.
	 */
	private boolean pathIsAvailable(String fileLocation) {
		boolean result = false;
		Path pathToCheck = Paths.get(fileLocation);
		boolean exists = Files.exists(pathToCheck);
		boolean notExists = Files.notExists(pathToCheck);
		if ( notExists || (exists && Files.isRegularFile(pathToCheck) && Files.isWritable(pathToCheck)) ) {
			result = true;
		}
		return result;
	}
}
