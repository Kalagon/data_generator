package Output;

import Generator.SensorData;
import Generator.SettingProvider;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * This class is used to handle storing the results. Using multiple objects of this class may cause issues if EXISTING.OVERWRITE is set and may shuffle the order of output lines.
 */
public class FileOutput {
	/**
	 * Used to set how to handle existing files in the place of the output file.
	 */
	public enum EXISTING {
		OVERWRITE, APPEND
	}

	private Path filePath;
	private FileOutputBuffer buffer;
	private EXISTING handling;

	/**
	 * Initializes the object with the values of SettingProvider.
	 * TODO: make handling configurable
	 */
	public FileOutput() {
		this.filePath = SettingProvider.get().getFilePath();
		this.buffer = new FileOutputBuffer();
		this.handling = EXISTING.APPEND;
		handleExistingFiles();
	}

	/**
	 * Initializes the object with the given parameters.
	 * @param filePath Where to save the output to.
	 * @param buffer The FileOutputBuffer to use.
	 * @param handling How to handle existing files.
	 */
	public FileOutput(Path filePath, FileOutputBuffer buffer, EXISTING handling) {
		this.filePath = filePath;
		this.buffer = buffer;
		this.handling = handling;
		handleExistingFiles();
	}

	/**
	 * Store a SensorData object in the buffer. If the buffer is full its contents will be written to disk.
	 * @param inputObject The object to store.
	 * @throws IOException In case writing to the file fails.
	 */
	public void save(SensorData inputObject) throws IOException {
		this.buffer.append(inputObject);
		if (this.buffer.isFull()) {
			this.writeToFile();
		}
	}

	/**
	 * Writes the contents of the buffer to the set file. Appends lines.
	 * @throws IOException In case writing to the file fails.
	 */
	public void writeToFile() throws  IOException {
		Files.write(this.filePath, this.buffer.getContents(), Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
	}

	/**
	 * Deletes existing files in the place of the selected output file if EXISTING.OVERWRITE is set.
	 */
	private void handleExistingFiles() {
		if (this.handling == EXISTING.OVERWRITE) {
			try {
				Files.deleteIfExists(this.filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
