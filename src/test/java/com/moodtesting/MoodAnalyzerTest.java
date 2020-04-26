package com.moodtesting;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    private String Null;

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyseMood("This is a sad message");
        Assert.assertEquals("SAD", mood);
    }
    @Test
    public void givenMessage_WhenHappy_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyseMood("This is a happy message");
        Assert.assertEquals("HAPPY", mood);
    }
    @Test
    public void givenMessage_WhenProper_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyseMood("I am in sad mood");
        Assert.assertEquals("SAD", mood);
    }
    @Test
    public void givenMessage_WhenProper_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyseMood("I am in any mood");
        Assert.assertEquals("HAPPY", mood);
    }
    @Test
    public void givenMessage_NoParameter_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    @Test
    public void givenMessage_InvalidMood_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(Null);
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("Invalid",mood);
    }

}
