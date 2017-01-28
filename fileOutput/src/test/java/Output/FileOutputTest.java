package Output;

import Generator.SensorData;
import Generator.SettingProvider;
import Main.SettingStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by oskar on 03.01.17.
 */
class FileOutputTest {
	@BeforeAll
	static void setUp() {
		SettingProvider.set(new SettingStore());
	}

	@Test
	void save() throws IOException {
		Path path = Paths.get("build/file.txt");
		FileOutputBuffer buffer = new FileOutputBuffer(50);
		FileOutput testObject = new FileOutput(path, buffer, FileOutput.EXISTING.APPEND);
		String expected = "0000 currentValue:0.3,precision:0.1,measurementUnit:C";
		testObject.save(new SensorData(0.3f, 0.1f, "C"));
		String actual = buffer.getContents().get(0);
		assertEquals(expected, actual);
	}

	@Test
	void writeToFile() throws IOException{
		Path path = Paths.get("build/file.txt");
		FileOutputBuffer buffer = new FileOutputBuffer(100);
		FileOutput testObject = new FileOutput(path, buffer, FileOutput.EXISTING.OVERWRITE);
		for (int i = 0; i < 3; i++) {
			testObject.save(new SensorData(10.2f, 0.1f, "C"));
		}
		testObject.writeToFile();
	}

}