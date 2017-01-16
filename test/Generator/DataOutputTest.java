package Generator;

import Main.SettingStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by oskar on 03.01.17.
 */
class DataOutputTest {
	private DataOutput testObject;

	@BeforeAll
	static void setUp() {
		SettingProvider.set(new SettingStore());
	}


	@Test
	void save() {

	}

}