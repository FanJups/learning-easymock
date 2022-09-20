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

    @Test
    public void testAdd() {
	// add the behavior of calc service to add two numbers
	EasyMock.expect(calcService.add(10.0, 20.0)).andReturn(30.00);

	// activate the mock
	EasyMock.replay(calcService);

	// test the add functionality
	Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
    }

}
