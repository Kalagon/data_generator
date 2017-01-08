package Generator;

import Main.SettingStore;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 04.01.17.
 */
class SettingProviderTest {
	private SettingProvider testObject;

	@BeforeEach
	void setUp() {
		SettingStore settings = new SettingStore();
		SettingProvider.set(settings);
		testObject = SettingProvider.get();
	}

	@Test
	void getGeneratorSeed() {

	}

	@Test
	void getOutputSize() {

	}

	@Test
	void getFilePath() {

	}

	@Test
	void getBufferSize() {

	}

	@Test
	void getNoiseAlgorithm() {

	}

}