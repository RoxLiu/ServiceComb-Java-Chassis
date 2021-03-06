/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.core.metrics;

import io.servicecomb.foundation.common.event.Event;

public class InvocationFinishedEvent implements Event {
  private final String operationName;

  private final long finishedTime;

  private final long processElapsedNanoTime;

  private final long totalElapsedNanoTime;

  private final String operationType;

  public String getOperationName() {
    return operationName;
  }

  public InvocationFinishedEvent(String operationName, String operationType, long finishedTime,
      long processElapsedNanoTime,
      long totalElapsedNanoTime) {
    this.operationName = operationName;
    this.operationType = operationType;
    this.finishedTime = finishedTime;
    this.processElapsedNanoTime = processElapsedNanoTime;
    this.totalElapsedNanoTime = totalElapsedNanoTime;
  }
}
