package Generator;

import Main.DataOutput;
import Main.SettingProvider;

import java.util.Random;

/**
 * The main class of the generator. Used to initialize and execute the other objects.
 */
public class Generator {

	private Sensor[] sensorList;
	private DataOutput outputHandler;
	private long outputSize;
	private int sensorCount;

	/**
	 * Initializes all parts of the object. All settings must be set properly before creating the Generator.
	 */
	public Generator() {
		initializeSensorList();
		initializeDataOutput();
		initializePrimitives();
	}

	/**
	 * Creates the list of sensors which will be used to generate the SimpleSensorData. Creates one sensor per requested type.
	 */
	private void initializeSensorList() {
		Random rng = SettingProvider.getRandomNumberGenerator();
		NoiseAlgorithm noiseAlgorithm = SettingProvider.getNoiseAlgorithm();
		SensorFactory.TYPE[] sensorTypes = SettingProvider.getSettingStore().getSensorTypes();
		this.sensorList = new Sensor[sensorTypes.length];
		for (int i = 0; i < sensorTypes.length; i++) {
			this.sensorList[i] = SensorFactory.createSensor(sensorTypes[i]);
		}
	}

	/**
	 * Sets the DataOutput handler to forward generated data to.
	 */
	private void initializeDataOutput() {
		this.outputHandler = SettingProvider.getOutputHandler();
	}

	/**
	 * Sets all primitive variables needed to execute the generation.
	 */
	private void initializePrimitives() {
		this.outputSize = SettingProvider.getSettingStore().getOutputSize();
		this.sensorCount = this.sensorList.length;
	}

	/**
	 * Loops through the list of sensors for the set amount of times to generate the SimpleSensorData objects and passes them to the DataOutput one by one.
	 */
	public void execute() {
		Sensor currentSensor;
		for (long i = 0; i < this.outputSize; i++) {
			currentSensor = this.sensorList[(int) ( i % sensorCount )];
			this.outputHandler.save(currentSensor.getData());
		}
	}
}
