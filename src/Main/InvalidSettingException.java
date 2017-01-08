package Main;

/**
 * Thrown if an incorrect setting is attempted to be set.
 */
public class InvalidSettingException extends Exception {
	private String type;

	InvalidSettingException(String message, String type) {
		super(message);
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
