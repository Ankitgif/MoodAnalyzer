package com.moodtesting;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    private String Null;
    //UC1
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is a sad message");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    @Test
    public void givenMessage_WhenHappy_ShouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is a happy message");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }
    //TC-1.1
    @Test
    public void givenMessage_WhenProper_ShouldReturnSad() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    //TC-1.2
    @Test
    public void givenMessage_WhenProper_ShouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in any mood");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }
    //Repeat TC-1.1
    @Test
    public void givenMessage_NoParameter_ShouldReturnSad() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    //UC2-->TC-2.1  //for handle exception
//    @Test
//    public void givenMessage_NullMood_ShouldReturnHappy(){
//        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(Null);
//        String mood = moodAnalyzer.analyseMood();
//        Assert.assertEquals("HAPPY",mood);
//    }
    //UC3-->TC-3.1 //for Null mood Throwing Custom Exception
    @Test
    public void givenMessage_NullMood_ShouldThrowCustomException(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(Null);
        try {
           String mood = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException exception) {
            Assert.assertEquals("Please enter proper mood", exception.getMessage());
        }
    }
}
