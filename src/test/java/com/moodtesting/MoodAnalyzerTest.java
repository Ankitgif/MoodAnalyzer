package com.moodtesting;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    private String Null;
    //UC1
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is a sad message");
        String mood = null;
        try {
            mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
    }
    //TC-1.1
    @Test
    public void givenMessage_WhenProper_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        String mood = null;
        try {
            mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
    }
    //TC-1.2
    @Test
    public void givenMessage_WhenProper_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in any mood");
        String mood = null;
        try {
            mood = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }
    //Repeat TC-1.1
    @Test
    public void givenMessage_NoParameter_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = null;
        try {
            mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
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
            Assert.assertEquals(MoodAnalysisException.exceptionType.NULL_MOOD,exception.type);
        }
    }
    //UC3-->TC-3.2 //for Empty mood Throwing Custom Exception
    @Test
    public void givenMessage_EmptyMood_ShouldThrowCustomException(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try{
            String mood = moodAnalyzer.analyseMood();
        }catch (MoodAnalysisException exception){
            Assert.assertEquals(MoodAnalysisException.exceptionType.EMPTY_MOOD,exception.type);
        }
    }
    //UC4-->TC-4.1 //Given class should return object
    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject(){
        MoodAnalyzer moodAnalyzer = null;
        try {
            moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
        MoodAnalyzer moodAnalyzer1 = new MoodAnalyzer();
        Assert.assertEquals(moodAnalyzer1, moodAnalyzer);
    }
    @Test
    public void givenWhen_ImproperClass_ShouldThrowCustomException(){
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalysisException exception) {
            Assert.assertEquals("Please enter proper class name",exception.getMessage());
        }

    }

}

