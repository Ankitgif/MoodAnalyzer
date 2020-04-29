package com.moodtesting;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
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
    public void givenMessage_NoParameter_ShouldReturnSad() {
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
    public void givenMessage_NullMood_ShouldThrowCustomException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(Null);
        try {
            String mood = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException exception) {
            Assert.assertEquals(MoodAnalysisException.exceptionType.NULL_MOOD, exception.type);
        }
    }

    //UC3-->TC-3.2 //for Empty mood Throwing Custom Exception
    @Test
    public void givenMessage_EmptyMood_ShouldThrowCustomException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try {
            String mood = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException exception) {
            Assert.assertEquals(MoodAnalysisException.exceptionType.EMPTY_MOOD, exception.type);
        }
    }

    //UC4-->TC-4.1 //Given class should return object
    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyzer = null;
        try {
            moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyzer");
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
        MoodAnalyzer moodAnalyzer1 = new MoodAnalyzer();
        Assert.assertEquals(moodAnalyzer1, moodAnalyzer);
    }

    //UC4-->TC-4.2 /Given Improper class name , throw class not found exception
    @Test
    public void givenWhen_ImproperClass_ShouldThrowCustomException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyze");
        } catch (MoodAnalysisException exception) {
            Assert.assertEquals("Please enter proper class name", exception.getMessage());
        }
    }
   // UC4-->TC-4.3 //Given constructor not proper , throw custom exception
//    @Test
//    public void givenWhen_ConstructorNotProper_ShouldThrowCustomException(){
//        try {
//            MoodAnalyzer moodAnalyzerClass = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyzer");
//        } catch (MoodAnalysisException exception) {
//            Assert.assertEquals("No such method error",exception.getMessage());
//        }
//    }

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        Class<?> moodAnalyzerClass = null;
        Constructor<?> moodConstructor = null;
        try {
            moodAnalyzerClass = Class.forName("com.moodtesting.MoodAnalyzer");
            moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance("I am in happy mood");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) moodObj;
            String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    //UC5->TC-5.1 //comparing objects
    @Test
    public void givenMoodAnalyser_WhenProper_ReturnMoodAnalyserObject(){
        MoodAnalyzer moodAnalyzer = null;
        try {
            moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyzer","I am in happy mood");
        } catch (MoodAnalysisException exception) {
           exception.printStackTrace();
        }
        MoodAnalyzer moodAnalyzer1 = new MoodAnalyzer("I am in happy mood");
        Assert.assertEquals(moodAnalyzer1,moodAnalyzer);
    }
    //UC5->TC-5.2 //Given Improper class name , throw class not found exception with parameterized constructor
    @Test
    public void givenClassName_WhenImproper_ShouldThrowCustomException(){
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyzer","I am in happy mood");
        } catch (MoodAnalysisException exception) {
            Assert.assertEquals("Please enter proper class name", exception.getMessage());
        }
    }
    //UC5->TC-5.3 //Given constructor not proper , throw custom exception
    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrowCustomException(){
        try {
            MoodAnalyzer moodAnalyzerClass = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyzer","I am in happy mood");
        } catch (MoodAnalysisException exception) {
            Assert.assertEquals("No such method error",exception.getMessage());
        }
    }
    //UC6-->TC-6.1 // Given happy message using reflection when proper should return happy mood
    @Test
    public void givenHappyMessage_WithReflection_ShouldReturnHappy(){
        Object myObject = null;
        try {
            myObject = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyzer","I am in happy mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
    }
    //UC6-->TC-6.2 // Given happy message when improper method should throw custom exception
    @Test
    public void givenHappyMessage_WithReflection_WhenImproperMethod_ShouldThrowCustomException(){
        Object myObject = null;
        try {
            myObject = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyzer","I am in happy mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyseMo");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
    }
    //UC7-->TC-7.1 //Set the field value and invoke method using reflection
    @Test
    public void givenEmptyMessage_WithReflection_ShouldReturnHappy(){
        try {
            Object myObject = MoodAnalyzerReflector.createMoodAnalyzer("com.moodtesting.MoodAnalyzer","");
            MoodAnalyzerReflector.setFieldValue(myObject, "message", "I am in happy mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException exception) {
            exception.printStackTrace();
        }
    }
}

