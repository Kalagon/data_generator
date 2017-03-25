package Standalone;

import Main.DataOutput;
import Main.Init;
import Main.SettingProvider;
import Output.FileOutput;
import Output.FileOutputSettingStore;

/**
 * Combines the core and fileOutput projects into a standalone application.
 */
public class Main {
	private static Main instance = new Main();
	private String outputLocation = "output.txt";
	private long bufferSize = 500;

	public static void main(String[] args) {
		instance.preprocessArgs(args);
		SettingProvider.setOutputHandler( instance.setupDataOutput() );
		Init.run(args);
	}

	/**
	 * Sets up the output handler. Creates a FileOutput.
	 */
	private DataOutput setupDataOutput() {
		FileOutputSettingStore settings = new FileOutputSettingStore(outputLocation, bufferSize);
		return new FileOutput(settings);
	}

	/**
	 * Preprocesses the given arguments so the actions can be executed in the proper order.
	 * @param args The command-line arguments.
	 */
	private void preprocessArgs(String[] args) {
		int i = 0;
		while (i < args.length) {
			switch (args[i]) {
				case "--output":
				case "-o":
					outputLocation = args[i + 1];
					i++;
					break;
				case "--buffersize":
					bufferSize = Long.parseLong(args[i + 1]);
					i++;
					break;
				case "--help":
				case "-h":
					System.out.println("Standalone: Possible options are --output <string> and --buffersize <long>.\n\r");
				default:
					break;
			}
			i++;
		}
	}
}
