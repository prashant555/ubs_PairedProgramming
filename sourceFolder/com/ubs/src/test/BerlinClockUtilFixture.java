package com.ubs.src.test;

import static com.ubs.src.test.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import com.src.constant.TimeProcessingConstants;
import com.src.utils.TimeConverterUtil;

/**
 * Test class for the timeconverterutil
 * 
 */
public class BerlinClockUtilFixture {
    private TimeConverterUtil berlinClockConverterUtil = new TimeConverterUtil();
    private String theTime;
    private int seconds;
    private int minutes;
    private int hours;
    private StringBuilder timeString = null;

    @Test
    public void berlinClockUtilAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock-util.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
        String timeComponent[] = theTime.split(TimeProcessingConstants.COLON);
        seconds = Integer.parseInt(timeComponent[TimeProcessingConstants.DEFAULT_TWO]);
        hours = Integer.parseInt(timeComponent[TimeProcessingConstants.DEFAULT_ZERO]);
        minutes = Integer.parseInt(timeComponent[TimeProcessingConstants.DEFAULT_ONE]);
    }

    @Then("the clock should look like $")
    public void thenTheSecondsAre(String theExpectedBerlinClockOutput) {
    	timeString = new StringBuilder();
    	berlinClockConverterUtil.berlinClockSecondRepresentation(seconds, timeString);
    	berlinClockConverterUtil.berlinClockHourRepresentation(hours, timeString);
    	berlinClockConverterUtil.berlinClockMinuteRepresentation(minutes, timeString);
    	
    	assertThat(timeString.toString()).isEqualTo(theExpectedBerlinClockOutput);
    }
}