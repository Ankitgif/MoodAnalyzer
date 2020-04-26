package com.moodtesting;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    private String Null;
    //UC1
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is a sad message");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    @Test
    public void givenMessage_WhenHappy_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is a happy message");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }
    //TC-1.1
    @Test
    public void givenMessage_WhenProper_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    //TC-1.2
    @Test
    public void givenMessage_WhenProper_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in any mood");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }
    //Repeat TC-1.1
    @Test
    public void givenMessage_NoParameter_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    //UC2
    @Test
    public void givenMessage_InvalidMood_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(Null);
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("Invalid",mood);
    }

}
