package com.moodtesting;

public class MoodAnalysisException extends Exception {
    public  enum exceptionType {NULL_MOOD, EMPTY_MOOD};
    exceptionType type;

     public MoodAnalysisException(String message){
         super(message);
   }

   MoodAnalysisException(String message, exceptionType type){
         super(message);
         this.type = type;
   }
}
