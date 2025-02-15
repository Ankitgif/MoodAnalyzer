package com.moodtesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {

    public static Constructor<?> getConstructor(String className, Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(param);
        } catch (ClassNotFoundException exception) {
            throw new MoodAnalysisException("Please enter proper class name", MoodAnalysisException.exceptionType.CLASS_NOT_FOUND);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Error", MoodAnalysisException.exceptionType.NO_SUCH_METHOD_ERROR);
        }
    }
    public static Object createMoodAnalyzer(Constructor<?> constructor, Object ... message) throws InvocationTargetException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
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
            throw new MoodAnalysisException("Invocation Target Exception",MoodAnalysisException.exceptionType.INVOCATION_TARGET_EXCEPTION);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No Such Method Error",MoodAnalysisException.exceptionType.NO_SUCH_METHOD_ERROR);
        }
        return moodAnalyserObject;
    }
    public static void setFieldValue(Object object, String fieldName, String fieldValue) throws MoodAnalysisException {
        Field field = null;
        try {
            field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException("No Such Field Error",MoodAnalysisException.exceptionType.NO_SUCH_FIELD_ERROR);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
