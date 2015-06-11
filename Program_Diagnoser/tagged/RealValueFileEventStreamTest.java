/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package opennlp.maxent.io;
import Implant.*;


import java.io.IOException;

import junit.framework.TestCase;
import opennlp.model.OnePassRealValueDataIndexer;
import opennlp.model.RealValueFileEventStream;

public class RealValueFileEventStreamTest extends TestCase {

  public void testLastLineBug() throws IOException {
Logger.log("RealValueFileEventStreamTest.testLastLineBug");
boolean _bug_switch = Bug_Switcher.has_bug("RealValueFileEventStreamTest.testLastLineBug");
if (_bug_switch)
	return;

    OnePassRealValueDataIndexer indexer;
    RealValueFileEventStream rvfes;
    
    rvfes = new RealValueFileEventStream(
        "src/test/resources/data/opennlp/maxent/io/rvfes-bug-data-ok.txt");
    try {
      indexer = new OnePassRealValueDataIndexer(rvfes, 1);
    } finally {
      rvfes.close();
    }
    assertEquals(1, indexer.getOutcomeLabels().length);

    rvfes = new RealValueFileEventStream(
        "src/test/resources/data/opennlp/maxent/io/rvfes-bug-data-broken.txt");
    try {
      indexer = new OnePassRealValueDataIndexer(rvfes, 1);
    } finally {
      rvfes.close();
    }
    assertEquals(1, indexer.getOutcomeLabels().length);
  }
}