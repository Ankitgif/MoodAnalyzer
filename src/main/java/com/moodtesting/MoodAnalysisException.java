package com.moodtesting;

public class MoodAnalysisException extends Exception {
    public  enum exceptionType {NULL_MOOD, EMPTY_MOOD, CLASS_NOT_FOUND,NO_SUCH_METHOD_ERROR, NO_SUCH_FIELD_ERROR, INVOCATION_TARGET_EXCEPTION};
    exceptionType type;

     public MoodAnalysisException(String message){
         super(message);
   }

   MoodAnalysisException(String message, exceptionType type){
         super(message);
         this.type = type;
   }
}
