package com.ubs.src.test;

import static com.ubs.src.test.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import com.src.exception.TimeConverterException;
import com.src.utils.TimeConverterValidatorUtil;

/**
 * Test Class for the timeconvertervalidatorutil
 * 
 */

public class BerlinClockValidatorUtilFixture {
    private String theTime;
    private Throwable throwable = null;

    @Test
    public void berlinClockValidatorUtilAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock-validation.story")
                .run();
    }

    
    @When("the time is $time")
    public void whenWrongTimeIsGiven(String time) {
        theTime = time;
        try{
        	TimeConverterValidatorUtil.timeContentValidator(theTime);
    		TimeConverterValidatorUtil.timeFormatValidator(theTime);
    		TimeConverterValidatorUtil.timeRangeValidater(theTime);
    	}catch(TimeConverterException converterException){
    		throwable = converterException;
    	}
    }
    
    @Then("the clock should look like $")
    public void verifyTime(String theExpectedBerlinClockOutput) {
    	assertThat(throwable.getMessage()).isEqualTo(theExpectedBerlinClockOutput);
        if(!(throwable instanceof TimeConverterException)){
        	assertThat(true).isEqualTo(false);
        }
    }
}