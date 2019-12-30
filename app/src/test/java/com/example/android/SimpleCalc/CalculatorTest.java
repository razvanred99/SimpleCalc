/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        final double resultAdd = mCalculator.add(-1d, 3d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        final double resultAdd = mCalculator.add(1.1f, 2.333d);
        assertThat(resultAdd, is(closeTo(3.433, 0.01)));
    }

    @Test
    public void subTwoNumbers() {
        final double resultSub = mCalculator.sub(3, 2);
        assertThat(resultSub, is(equalTo(1d)));
    }

    @Test
    public void subTwoNumbersWithNegativeResult() {
        final double resultSub = mCalculator.sub(4, 5);
        assertThat(resultSub, is(equalTo(-1d)));
    }

    @Test
    public void mulTwoNumbers() {
        final double resultMul = mCalculator.mul(3, 4);
        assertThat(resultMul, is(equalTo(12d)));
    }

    @Test
    public void mulTwoNumbersZero() {
        final double resultMul = mCalculator.mul(0, 2);
        assertThat(resultMul, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers() {
        final double resultDiv = mCalculator.div(3, 2);
        assertThat(resultDiv, is(equalTo(1.5d)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows() {
        mCalculator.div(2, 0);
    }
}