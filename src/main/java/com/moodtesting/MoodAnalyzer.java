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
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch(NullPointerException e){
            throw new MoodAnalysisException("Please enter proper mood");                //UC-3 Throwing Custom Exception
            }
    }


}
