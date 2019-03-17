package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;

public class HomePage extends AbstractPage{

    /**
     * Constructor
     *
     * @param baseTest
     */
    public HomePage(BaseTest baseTest) {
        super(baseTest);
        baseTest.waitTillElementIsVisible(divPage);
    }
}
