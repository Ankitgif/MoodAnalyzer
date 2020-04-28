package com.moodtesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer() throws MoodAnalysisException {
        try{
            Class<?> moodAnalyzerClass = Class.forName("com.moodtesting.MoodAnaly");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            Object moodObj = moodConstructor.newInstance();
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException exception) {
            throw new MoodAnalysisException("Please enter proper class name", MoodAnalysisException.exceptionType.CLASS_NOT_FOUND);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
