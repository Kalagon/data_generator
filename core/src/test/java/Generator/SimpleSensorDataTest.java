package Generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleSensorDataTest {
	private SimpleSensorData testObject;

	@BeforeEach
	void setUp() {
		testObject = new SimpleSensorData(24.5f, 0.5f, "°C");
	}

    @Test
    public void testToString() {
		String expectedResult = "currentValue:24.5,precision:0.5,measurementUnit:°C";
        assertEquals(expectedResult, testObject.toString());
    }

}