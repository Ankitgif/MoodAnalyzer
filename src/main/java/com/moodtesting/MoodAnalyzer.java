package com.moodtesting;

public class MoodAnalyzer {

    private  String message;
    //Refactor In UC1 after TC-1.2
    public MoodAnalyzer(){
        message = "I am in sad mood";
    }
    //Refactor In UC1 after TC-1.2
    public MoodAnalyzer(String message){
        this.message = message;
    }
    public String analyseMood() throws MoodAnalysisException {                           //UC-2 Handle exception
        try {
            if(message.length() == 0)                                                   //Checking message is empty or not
                throw new MoodAnalysisException("Mood should not be empty", MoodAnalysisException.exceptionType.EMPTY_MOOD);
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch(NullPointerException exception){
            throw new MoodAnalysisException("Please enter proper mood", MoodAnalysisException.exceptionType.NULL_MOOD);                //UC-3 Throwing Custom Exception
            }
    }


}
