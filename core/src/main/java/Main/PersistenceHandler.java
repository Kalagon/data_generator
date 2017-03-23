package Main;

import com.esotericsoftware.yamlbeans.YamlConfig;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible for de/serializing settings.
 */
public class PersistenceHandler {

	/**
	 * Saves the current configuration to a file. Saves SettingStore and enclosed objects. Utilizes YamlBeans. Prints the stacktrace if it fails.
	 * @param location Where to save the file. Give the complete name with extension.
	 */
	protected void persist(String location) {
		YamlConfig config = new YamlConfig();
		config.writeConfig.setWriteDefaultValues(true);
		try {
			YamlWriter writer = new YamlWriter(new FileWriter(location), config);
			writer.write(SettingProvider.getSettingStore());
			writer.close();
		} catch (IOException e) {
			System.out.print("Unable to write config to file! Error:\n\r");
			e.printStackTrace();
		}
	}

	/**
	 * Reads the SettingStore from a file and sets up the SettingProvider. Prints the stacktrace if it fails.
	 * @param location The file to read. Give the complete name with extension.
	 */
	protected void load(String location) {
		try {
			YamlReader reader = new YamlReader(new FileReader(location));
			SettingStore settings = reader.read(SettingStore.class);
			SettingProvider.setSettingStore(settings);
			reader.close();
		} catch (IOException e) {
			System.out.print("Unable to read config from file! Error:\n\r");
			e.printStackTrace();
		}
	}
}
