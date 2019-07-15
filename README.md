# Data Generator

This is a flexible framework that can be used to generate synthetic output of sensor networks.
Nearly all aspects of it are modular and easily expandable, so it could also be used to generate arbitrary time series data.

It was originally written as part of my bachelor's thesis.

## Building

This project uses Gradle to manage dependencies and build the application.  
To build a stand-alone jar file run task `fullJar` in subproject 'standalone'.  

## Usage

`java -jar <application> [<arguments>]`  

The following command-line arguments are available:  

`--help, -h`  
Prints a list of available commands.  
`--outputsize <long>, -n <long>`  
The amount of output that should be generated. Default: 1000  
`--output <string>, -o <string>`  
Sets the file the output will be written to. Default: "output.txt"  
`--buffersize <long>`  
Defines how many lines should be stored in the buffer at a time. Default: 500  
`--save, -s`  
Write the configuration to a file.  
`--load, -l`  
Load the configuration from a file.  
`--settinglocation <string>`  
The file to use for configuration reads/writes. Default: "settings.yml"  
`--createconfigonly`  
Only writes the config file and exits.  

The settings file is generated using <a href="https://github.com/EsotericSoftware/yamlbeans">YamlBeans</a>. It is 
written in yaml.  

## Output

Each output object is represented as a single line in the output file. An object line looks like this, depending on 
settings 
and available data types:  
`0984 currentValue:34.055492,precision:0.5,measurementUnit:°C`  
This corresponds to  
`<timestamp> <data>`

## Errors

The application currently does not have full error handling. It should usually print information on errors to stdout. Some notes:  
Exit code 2: writing outputs to disk failed.