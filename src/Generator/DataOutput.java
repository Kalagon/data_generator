package Generator;

import java.nio.file.Path;

/**
 * Created by oskar on 03.01.17.
 */
public class DataOutput {
	private Path fileLocation;
	private DataOutputBuffer buffer;

	public DataOutput(Path fileLocation) {
		this.fileLocation = fileLocation;
	}

	public void save(SensorData inputObject) {

	}

	private void writeToFile() {

	}

}
