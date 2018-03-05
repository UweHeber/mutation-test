# Mutation testing with Pitest

Inspired by the last [JUG Saxony visit][1], where [Sven Ruppert][2] held a 
talk about mutation testing I wanted to try out this possibility to develop 
useful test cases with high test coverage.

## Compatibility / Runtime Environment
Unfortunately, the PITest plugin does not yet support Java 9 and JUnit 5 
natively, so the example has currently following requirements regarding runtime
environment :

* Java 8
* JUnit 4.12
* Maven 3.5
* PITest 1.3.*
* AssertJ 3.9.*

## Integrate PITest
It is very easy to use PITest. 

1. Add the dependency to ```pom.xml``` file:
    ```xml
    <dependency>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-parent</artifactId>
        <version>${pitest.version}</version>
        <type>pom</type>
        <scope>test</scope>
    </dependency>
    ```
2. Add plugin configuration to ```pom.mxl``` file
    ```xml
    <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.3.2</version>
        <configuration>
            <mutators>
                <mutator>ALL</mutator>
            </mutators>
            <targetClasses>
                <param>it.heber.sandbox.mutationtest.*</param>
            </targetClasses>
            <targetTests>
                <param>it.heber.sandbox.*</param>
            </targetTests>
        </configuration>
    </plugin>
    ```
The example above is the simplest. PITest provides various configurations very 
well described into [PITest Maven Quick Start page][3].

Simple example to learn about mutation testing using "pitest", maven plugin will 
generate an html report with useful information about mutants.

## Run PITest

To use pitest, all you have to do is activate the appropriate plugin for Maven 
projects and start ```mvn pitest:mutationCoverage``` after running the test.

## PITest results

PITest provides very understandable reports. Together with the line code 
coverage, it measures the mutation coverage. There are statistics at package 
level. These reports can be transferred to a reporting server via the building/
test chain and thus made accessible.

![alt text][4]


## Installation and Setup

Following steps are required to install the plugin:
1.  Clone this repository to your developer workspace instance as `mutation-test` project:

    `$ git clone https://github.com/UweHeber/mutation-test mutation-test`
    
2. Run following Maven commands:
    
    * ```mvn clean install```
    * ```mvn pitest:mutationCoverage```
 
## License 
 This example is licensed under the MIT license. See LICENSE for details.


[1]:https://jugsaxony.org/veranstaltungen/98/start_hunting_the_bugs_mutation_testing/
[2]:https://www.gitbook.com/@sven-ruppert
[3]:http://pitest.org/quickstart/maven/
[4]:http://heber.it/images/github/pitest-webreport.png "Screen shot - PITest Web report"
