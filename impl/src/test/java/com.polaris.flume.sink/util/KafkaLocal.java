/**
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 limitations under the License.
 */

package com.polaris.flume.sink.util;

import kafka.server.KafkaConfig;
import kafka.server.KafkaServerStartable;

import java.io.IOException;
import java.util.Properties;

/**
 * A local Kafka server for running unit tests.
 * Reference: https://gist.github.com/fjavieralba/7930018/
 */
public class KafkaLocal {

    public KafkaServerStartable kafka;
    public ZooKeeperLocal zookeeper;

    public KafkaLocal(Properties kafkaProperties) throws IOException, InterruptedException{
        KafkaConfig kafkaConfig = new KafkaConfig(kafkaProperties);

        //start local kafka broker
        kafka = new KafkaServerStartable(kafkaConfig);
    }

    public void start() throws Exception{
        kafka.startup();
    }

    public void stop(){
        kafka.shutdown();
    }

}