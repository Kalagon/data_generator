package Output;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Object to store settings for the FileOutput DataOutput.
 */
public class FileOutputSettingStore implements Serializable {
	private Path fileLocation;
	private long bufferSize;
	private FileOutput.EXISTING existingFileHandling = FileOutput.EXISTING.OVERWRITE;

	public FileOutputSettingStore(String fileLocation, long bufferSize) {
		this.fileLocation = Paths.get(fileLocation);
		this.bufferSize = bufferSize;
	}

	public FileOutput.EXISTING getExistingFileHandling() {
		return existingFileHandling;
	}

	public void setExistingFileHandling(FileOutput.EXISTING existingFileHandling) {
		this.existingFileHandling = existingFileHandling;
	}

	public Path getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = Paths.get(fileLocation);
	}

	public long getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(long bufferSize) {
		this.bufferSize = bufferSize;
	}
}
