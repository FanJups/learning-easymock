package com.tutorialspoint.easymock;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.tutorialspoint.easymock.mathapplication.MathApplicationTest;
import com.tutorialspoint.easymock.stocks.PortfolioTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ PortfolioTest.class, MathApplicationTest.class, })
public class TestSuite {

}
