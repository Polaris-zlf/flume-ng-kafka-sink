## Dependency Versions
- Apache Flume - 1.5.0
- Apache Kafka - 0.8.1.1

## Prerequisites
- Java 1.6 or higher
- [Apache Maven 3](http://maven.apache.org)
- An [Apache Flume](https://flume.apache.org) installation (See the dependent version above)
- An [Apache Kafka](http://kafka.apache.org) installation (See the dependent version above)

## Building the project
> mvn clean install

This will compile the project and the binary distribution(flume-kafka-sink-dist-x.x.x-bin.zip) will be copied into '${project_root}/dist/target' directory.

## Setting up

1. Build the project as per the instructions in the previous subsection.
2. Unzip the binary distribution(flume-kafka-sink-dist-x.x.x-bin.zip) inside ${project_root}/dist/target.
3. There are two ways to include this custom sink in Flume binary installation.

_Recommended Approach_
- Create a new directory inside `plugins.d` directory which is located in `${FLUME_HOME}`. If the `plugins.d` directory is not there, go ahead and create it. We will call this new directory that was created inside plugins.d 'kafka-sink'. You can give it any name depending on the naming conventions you prefer.
- Inside this new directory (kafka-sink) create two subdirectories called `lib` and `libext`.
- You can find the jar files for this sink inside the `lib` directory of the extracted archive. Copy `flume-kafka-sink-impl-x.x.x.jar` into the `plugins.d/kafka-sink/lib` directory. Then copy the rest of the jars into the `plugins.d/kafka-sink/libext` directory.

This is how it'll look like at the end.
```
${FLUME_HOME}
 |-- plugins.d
 		|-- kafka-sink
 			|-- lib
   				|-- flume-kafka-sink-impl-x.x.x.jar
 			|-- libext
   				|-- kafka_x.x.-x.x.x.x.jar
   				|-- metrics-core-x.x.x.jar
   				|-- scala-library-x.x.x.jar


Configuration

type = com.polaris.flume.sink.KafkaSink
topic = default-flume-topic
preprocessor = com.polaris.flume.sink.SimpleMessagePreprocessor


编译时可能报下面的错：不用管
ERROR Closing socket for /xxx.xxx.xxx.xxx because of error (kafka.network.Processor)
java.io.IOException: Connection reset by peer
        at sun.nio.ch.FileDispatcherImpl.write0(Native Method)
        at sun.nio.ch.SocketDispatcher.write(SocketDispatcher.java:47)
        at sun.nio.ch.IOUtil.writeFromNativeBuffer(IOUtil.java:93)
        at sun.nio.ch.IOUtil.write(IOUtil.java:65)
        at sun.nio.ch.SocketChannelImpl.write(SocketChannelImpl.java:487)
        at kafka.api.TopicDataSend.writeTo(FetchResponse.scala:122)
        at kafka.network.MultiSend.writeTo(Transmission.scala:101)
        at kafka.api.FetchResponseSend.writeTo(FetchResponse.scala:219)
        at kafka.network.Processor.write(SocketServer.scala:375)
        at kafka.network.Processor.run(SocketServer.scala:247)
        at java.lang.Thread.run(Thread.java:745)