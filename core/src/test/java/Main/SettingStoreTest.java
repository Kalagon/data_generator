package Main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oskar on 29.12.16.
 */
class SettingStoreTest {
	private SettingStore testObject;
	private int testInt = 6;
	private float testFloat = 3.5f;
	private String testString = "/home/oskar/test/test";

	@BeforeEach
	void setUp() throws InvalidSettingException {

		this.testObject = new SettingStore();
	}

	@Test
	void setGetGeneratorSeed() {
		testObject.setGeneratorSeed(testInt);
		assertEquals(testInt, testObject.getGeneratorSeed());
	}

	@Test
	void setGetOutputSize() {
		testObject.setOutputSize(testInt);
		assertEquals(testInt, testObject.getOutputSize());
	}

	@Test
	void setGetFileLocation() {
		try {
			testObject.setFileLocation(testString);
		} catch (InvalidSettingException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
		assertEquals(testString, testObject.getFileLocation());
	}

	@Test
	void setGetBufferSize() {
		testObject.setBufferSize(testInt);
		assertEquals(testInt, testObject.getBufferSize());
		testObject.setBufferSize(-1);
		assertEquals(0, testObject.getBufferSize());
	}

	@Test
	void setGetNoiseAlgorithm() {
		assertEquals(NoiseAlgorithms.ALGORITHMS.RANDOM, testObject.getNoiseAlgorithm());
	}


}