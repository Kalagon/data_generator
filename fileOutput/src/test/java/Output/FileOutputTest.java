package Output;

import Generator.SimpleSensorData;
import Main.SettingProvider;
import Main.SettingStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileOutputTest {

	@BeforeAll
	static void setUpAll() {
		SettingProvider.setSettingStore(new SettingStore());
	}

	@Test
	void save() throws IOException {
		FileOutputSettingStore settings = new FileOutputSettingStore("build/testfile.txt", 50);
		FileOutput testObject = new FileOutput(settings);
		String expected = "0000 currentValue:0.3,precision:0.1,measurementUnit:C";
		testObject.save(new SimpleSensorData(0.3f, 0.1f, "C"));
		String actual = testObject.getBuffer().getContents().get(0);
		assertEquals(expected, actual);
	}

	@Test
	void flush() throws IOException {
		FileOutputSettingStore settings = new FileOutputSettingStore("build/testfile.txt", 100);
		FileOutput testObject = new FileOutput(settings);
		for (int i = 0; i < 3; i++) {
			testObject.save(new SimpleSensorData(10.2f, 0.1f, "C"));
		}
		testObject.flush();
	}

}