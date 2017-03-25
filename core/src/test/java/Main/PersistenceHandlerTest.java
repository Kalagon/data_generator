package Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersistenceHandlerTest {
	private PersistenceHandler testObject;
	private String location = "build/test.yml";

	@BeforeEach
	void setUp() {
		testObject = new PersistenceHandler();
	}

	@Test
	void persist() throws IOException {
		testObject.persist(location);
	}

	@Test
	void load() {
		SettingStore before = SettingProvider.getSettingStore();
		testObject.load(location);
		SettingStore after = SettingProvider.getSettingStore();
		assertNotEquals(before, after);
	}

}