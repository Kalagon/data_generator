package Output;

import Generator.DataOutput;
import Generator.SensorData;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * This class is used to handle storing the results. Using multiple objects of this class may cause issues if EXISTING.OVERWRITE is setSettingStore and may shuffle the order of output lines.
 */
public class FileOutput implements DataOutput {
	/**
	 * Used to setSettingStore how to handle existing files in the place of the output file.
	 */
	public enum EXISTING {
		OVERWRITE, APPEND
	}

	private Path filePath;
	private FileOutputBuffer buffer;
	private EXISTING handling;

	/**
	 * Initializes the object with the given parameters.
	 * @param settings The FileOutputSettingStore object.
	 */
	public FileOutput(FileOutputSettingStore settings) {
		this.filePath = settings.getFileLocation();
		this.buffer = new FileOutputBuffer(settings.getBufferSize());
		this.handling = settings.getExistingFileHandling();
		handleExistingFiles();
	}

	public FileOutputBuffer getBuffer() {
		return this.buffer;
	}

	/**
	 * Store a SensorData object in the buffer. If the buffer is full its contents will be written to disk.
	 * @param inputObject The object to store.
	 */
	public void save(SensorData inputObject) {
		this.buffer.append(inputObject);
		if (this.buffer.isFull()) {
			try {
				this.writeToFile();
			} catch (IOException e) {
				System.exit(2);
			}
		}
	}

	/**
	 * Writes the contents of the buffer to the setSettingStore file. Appends lines.
	 * @throws IOException In case writing to the file fails.
	 */
	public void writeToFile() throws  IOException {
		Files.write(this.filePath, this.buffer.getContents(), Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
	}

	/**
	 * Deletes existing files in the place of the selected output file if EXISTING.OVERWRITE is setSettingStore.
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
