package com.moodtesting;

public class MoodAnalysisException extends Exception {
    public  enum exceptionType {NULL_MOOD, EMPTY_MOOD, CLASS_NOT_FOUND};
    exceptionType type;

     public MoodAnalysisException(String message){
         super(message);
   }

   MoodAnalysisException(String message, exceptionType type){
         super(message);
         this.type = type;
   }
}
