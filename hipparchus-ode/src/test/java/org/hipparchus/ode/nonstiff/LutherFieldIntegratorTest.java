/*
 * Licensed to the Hipparchus project under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The Hipparchus project licenses this file to You under the Apache License, Version 2.0
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

package org.hipparchus.ode.nonstiff;


import org.hipparchus.Field;
import org.hipparchus.RealFieldElement;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.exception.MathIllegalStateException;
import org.hipparchus.util.Decimal64Field;
import org.junit.Test;

public class LutherFieldIntegratorTest extends RungeKuttaFieldIntegratorAbstractTest {

    protected <T extends RealFieldElement<T>> RungeKuttaFieldIntegrator<T>
    createIntegrator(Field<T> field, T step) {
        return new LutherFieldIntegrator<T>(field, step);
    }

    @Override
    public void testNonFieldIntegratorConsistency() {
        doTestNonFieldIntegratorConsistency(Decimal64Field.getInstance());
    }

    @Override
    public void testMissedEndEvent()
        throws MathIllegalArgumentException, MathIllegalStateException {
        doTestMissedEndEvent(Decimal64Field.getInstance(), 1.0e-15, 1.0e-15);
    }

    @Override
    public void testSanityChecks()
        throws MathIllegalArgumentException, MathIllegalStateException {
        doTestSanityChecks(Decimal64Field.getInstance());
    }

    @Override
    public void testDecreasingSteps()
        throws MathIllegalArgumentException, MathIllegalStateException {
        doTestDecreasingSteps(Decimal64Field.getInstance(), 3.6, 1.0, 1.0e-10);
    }

    @Override
    public void testSmallStep()
         throws MathIllegalArgumentException, MathIllegalStateException {
        doTestSmallStep(Decimal64Field.getInstance(), 8.7e-17, 3.6e-15, 1.0e-12, "Luther");
    }

    @Override
    public void testBigStep()
        throws MathIllegalArgumentException, MathIllegalStateException {
        doTestBigStep(Decimal64Field.getInstance(), 2.7e-5, 1.7e-3, 1.0e-12, "Luther");
    }

    @Override
    public void testBackward()
        throws MathIllegalArgumentException, MathIllegalStateException {
        doTestBackward(Decimal64Field.getInstance(), 2.4e-13, 4.3e-13, 1.0e-12, "Luther");
    }

    @Override
    public void testKepler()
        throws MathIllegalArgumentException, MathIllegalStateException {
        doTestKepler(Decimal64Field.getInstance(), 2.18e-7, 4.0e-10);
    }

    @Override
    public void testStepSize()
        throws MathIllegalArgumentException, MathIllegalStateException {
        doTestStepSize(Decimal64Field.getInstance(), 1.0e-22);
    }

    @Override
    public void testSingleStep() {
        doTestSingleStep(Decimal64Field.getInstance(), 6.0e-12);
    }

    @Override
    public void testTooLargeFirstStep() {
        doTestTooLargeFirstStep(Decimal64Field.getInstance());
    }

    @Override
    public void testUnstableDerivative() {
        doTestUnstableDerivative(Decimal64Field.getInstance(), 4.0e-15);
    }

    @Override
    public void testDerivativesConsistency() {
        doTestDerivativesConsistency(Decimal64Field.getInstance(), 1.0e-20);
    }

    @Override
    public void testPartialDerivatives() {
        doTestPartialDerivatives(4.4e-13, new double[] { 2.3e-12, 5.6e-13, 9.5e-14, 9.5e-14, 5.6e-13 });
    }

    @Test
    public void testSecondaryEquations() {
        doTestSecondaryEquations(Decimal64Field.getInstance(), 1.0e-12, 5.6e-13);
    }

}
