/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hipparchus.ml.neuralnet.sofm;

/**
 * Provides the learning rate as a function of the number of calls
 * already performed during the learning task.
 *
 * @since 3.3
 */
public interface LearningFactorFunction {
    /**
     * Computes the learning rate at the current call.
     *
     * @param numCall Current step of the training task.
     * @return the value of the function at {@code numCall}.
     */
    double value(long numCall);
}