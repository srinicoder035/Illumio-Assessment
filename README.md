# Illumio-Assessment

## Overview

This repository is for working with default and custom versions of AWS Flow log records and user defined lookup tables to generate statistics on the Port/Protocol and Tag Frequencies.

The Language chosen to address the problem is Java and Maven is used for project management. 
Testing is done using JUnit.

## Working

The approach taken to compute Port/Protocol and Tag Frequencies is the use of Map Reduce Concept using Streams in Java. This approach is ideal for scaling in a distributed environment. The method can also be further optimized by using Parallel Streams in realtime for larger inputs. Parallel Streams is not used in the project considering the Input constraints are smaller and parallelization is not very effective for this size of inputs.

The overall flow of working is as follows
- The Parser Classes (FlowLogParser and LookupParser) parse input data from the respective Files into corresponding Java Objects (BaseFlowLogEntry, LookupEntry) for processing.
- The LookupParser creates a LookupMapper for faster access of Lookup Records.
- The Processor Classes (TagCounterProcessor, PortProtocolProcessor) work on the created Java Objects to produce results which are flushed to respective output files (TagCount, PortProtocolCount) after computation.


Design choices in the system include using Inheritance to create Objects to hold different versions of the logs.
Builder Classes are created for different versions of logs to help create objects with different set of fields easily.

BaseFlowLogEntry Class is maintained as Abstract Class to help facilitate future updations of version of log.

## Code Structure

Packages under Src
- The Models Package contains all the Classes required for holding the input.
- The Parser Package contains code to parse data from files to the corresponding objects for further processing.
- The Processor Package contains code to process data into meaningful results generating Port/Protocol and Tag Frequencies.
- The Utility Package contains all the utilities needed for execution like File Writing utilities and so on.
- The Resource Package contains input Files and also the output Files.

All the Testing files are under Test

Pom.xml contains all the dependencies required for the project.

## Input Files

- StressTestFlowLogDefault - Contains input for Default Log Version 2 with file size slightly greater than 10 MB.
- StressTestLookupDefault - Contains input for Lookup Table for Default Log Version with 10000 mappings.
- StressTestFlowLogCustom - Contains input for Custom Log version with file size slightly greater than 10 MB.
- StressTestLookupCustom - Contains input for Lookup Table for Custom Log Version with 10000 mappings.

- ProtocolNumberMapping - File containing the Protocol Number and corresponding names in AWS Flow Logs (Provided by AWS)

## Output Evaluation

The sum of frequencies in the Tag Frequencies & Port/Protocol Frequencies will match with the number of entries in the Flow log records indiciating all flow logs have been processed.

## Constraints

The version of Java used for this application is *JavaSE-22* 

While testing for new inputs, please ensure the following are maintained

- It is mandatory for file containing the Flow log to have the names of the fields as the first line.
- The names of the fields should match with the attribute names in the corresponding version Model class for ensuring smooth running of code.
- It is mandatory for file containing the Lookup Table to have the names of the input fields as the first line.
- The output for Port/Protocol Frequency is updated in PortProtocolCount.txt by default. 
- The output for Tag Frequency is updated in TagCount.txt by default.

## Testing

All the functional code in the repository have been tested using JUnit.
