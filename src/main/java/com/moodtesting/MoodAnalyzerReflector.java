package com.moodtesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {

    public static MoodAnalyzer createMoodAnalyzer(String name) throws MoodAnalysisException {
        try{
            Class<?> moodAnalyzerClass = Class.forName(name);
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            Object moodObj = moodConstructor.newInstance();
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException exception) {
            throw new MoodAnalysisException("Please enter proper class name", MoodAnalysisException.exceptionType.CLASS_NOT_FOUND);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Error",MoodAnalysisException.exceptionType.NO_SUCH_METHOD_ERROR);
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

    public static MoodAnalyzer createMoodAnalyzer(String name, String message) throws MoodAnalysisException {
        try{
            Class<?> moodAnalyzerClass = Class.forName(name);
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException exception) {
            throw new MoodAnalysisException("Please enter proper class name", MoodAnalysisException.exceptionType.CLASS_NOT_FOUND);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Error",MoodAnalysisException.exceptionType.NO_SUCH_METHOD_ERROR);
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
    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalysisException {
        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Error",MoodAnalysisException.exceptionType.NO_SUCH_METHOD_ERROR);
        }
        return moodAnalyserObject;
    }
    public static void setFieldValue(Object object, String fieldName, String fieldValue){
        Field field = null;
        try {
            field = object.getClass().getField(fieldName);
            field.setAccessible(true);
            field.set(object,fieldValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
