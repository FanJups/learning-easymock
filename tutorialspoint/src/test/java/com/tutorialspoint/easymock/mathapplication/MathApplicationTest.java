package com.tutorialspoint.easymock.mathapplication;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(EasyMockRunner.class)
public class MathApplicationTest {

    // @TestSubject annotation is used to identify class which is going to use the
    // mock object
    @TestSubject
    MathApplication mathApplication = new MathApplication();

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test(expected = RuntimeException.class)
    public void testAdd() {
	// add the behavior to throw exception
	EasyMock.expect(calcService.add(10.0, 20.0)).andThrow(new RuntimeException("Add operation not implemented"));

	/*
	 * This line activates the mock. If this line is commented, the test will fail.
	 */

	EasyMock.replay(calcService);

	// test the add functionality
	Assert.assertEquals(30.0, mathApplication.add(10.0, 20.0), 0);

	// verify call to calcService is made or not
	/*
	 * If add method from mathapplication doesn't call the add method from
	 * calcservice, we get a failure.
	 */
	EasyMock.verify(calcService);
    }

}
