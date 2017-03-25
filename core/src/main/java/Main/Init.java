package Main;

import Generator.Generator;

/**
 * This class is used to initialize and start the program. It also processes command-line arguments.
 */
public class Init {

	private static Init instance = new Init();
	private boolean onlyCreateConfigFile = false;
	private boolean persist = false;
	private boolean load = false;
	private String settingsLocation = "settings.yml";
	private long outputSize = 1000;
	private PersistenceHandler persistenceHandler;

	/**
	 * Processes command-line arguments, sets up the application, and executes the Generator.
	 * @param args Command-line arguments
	 */
	public static void run(String[] args) {
		instance.preprocessArgs(args);
		instance.executeArgs();
		Generator generator = new Generator();
		generator.execute();
	}

	/**
	 * Preprocesses the given arguments so the actions can be executed in the proper order.
	 * @param args The command-line arguments.
	 */
	private void preprocessArgs(String[] args) {
		int i = 0;
		while (i < args.length) {
			switch (args[i]) {
				case "--createconfigonly":
					onlyCreateConfigFile = true;
				case "--save":
				case "-s":
					persist = true;
					break;
				case "--load":
				case "-l":
					load = true;
					break;
				case "--settinglocation":
					settingsLocation = args[i + 1];
					i++;
					break;
				case "--outputsize":
				case "-n":
					long tmp = Long.parseLong(args[i + 1]);
					outputSize = (tmp > 0 ? tmp : 1000);
					i++;
					break;
				default:
					System.out.println("Unrecognized option.\n\rPossible options are --save, --load, --settinglocation <string>, --outputsize <long> and --createconfigonly.");
					System.exit(1);
					break;
			}
			i++;
		}
	}

	/**
	 * Executes actions based on command-line arguments passed to the application.
	 */
	private void executeArgs() {
		if (load) {
			persistenceHandler = new PersistenceHandler();
			persistenceHandler.load(settingsLocation);
		}
		//creates default SettingStore if none was loaded
		SettingStore settings = SettingProvider.getSettingStore();
		if (outputSize != 1000) {
			settings.setOutputSize(outputSize);
		}
		if (persist || onlyCreateConfigFile) {
			if (persistenceHandler == null) {
				persistenceHandler = new PersistenceHandler();
			}
			persistenceHandler.persist(settingsLocation);
		}
	}


}