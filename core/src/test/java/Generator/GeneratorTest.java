package Generator;

import Main.SettingProvider;
import Main.SettingStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
	private DataOutputMock mockOutput;
	private Generator testObject;
	private long outputSize = 10;

	@BeforeEach
	void setUp() {
		SettingStore settings = new SettingStore();
		settings.setOutputSize(this.outputSize);
		settings.setRange(10,11);
		SettingProvider.setSettingStore(settings);
		this.mockOutput = new DataOutputMock();
		SettingProvider.setOutputHandler(this.mockOutput);
		SettingProvider.setRandomNumberGenerator(new RandomMock());
		SettingProvider.setNoiseAlgorithm(new RandomNoiseAlgorithmMock());
		this.testObject = new Generator();
	}

	@Test
	void execute() {
		ArrayList<SimpleSensorData> expected = new ArrayList<SimpleSensorData>();
		for (int i = 0; i < this.outputSize; i++) {
			expected.add(new SimpleSensorData(94.1f, 0.5f, "°F"));
		}
		testObject.execute();
		ArrayList<SensorData> output = this.mockOutput.getSavedList();
		assertEquals(expected.toString(), output.toString());
	}

}

