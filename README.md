## Building
This project uses Gradle to manage dependencies and build the application.<br>
To build a stand-alone jar file run task `fullJar` in subproject 'standalone'.<br>

## Usage
`java -jar <application> [<arguments>]`<br>

The following command-line arguments are available:<br>

`--help, -h`<br>
Prints a list of available commands.<br>
`--outputsize <long>, -n <long>`<br>
The amount of output that should be generated. Default: 1000<br>
`--output <string>, -o <string>`<br>
Sets the file the output will be written to. Default: "output.txt"<br>
`--buffersize <long>`<br>
Defines how many lines should be stored in the buffer at a time. Default: 500<br>
`--save, -s`<br>
Write the configuration to a file.<br>
`--load, -l`<br>
Load the configuration from a file.<br>
`--settinglocation <string>`<br>
The file to use for configuration reads/writes. Default: "settings.yml"<br>
`--createconfigonly`<br>
Only writes the config file and exits.<br>

The settings file is generated using <a href="https://github.com/EsotericSoftware/yamlbeans">YamlBeans</a>. It is 
written in yaml.<br>

## Output

Each output object is represented as a single line in the output file. An object line looks like this, depending on 
settings 
and available data types:<br>
`0984 currentValue:34.055492,precision:0.5,measurementUnit:°C`<br>
This corresponds to<br>
`<timestamp> <data>`

## Errors

The application currently does not have full error handling. It should usually print information on errors to stdout. Some notes:<br>
Exit code 2: writing outputs to disk failed.