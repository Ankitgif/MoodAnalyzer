package com.moodtesting;

public class MoodAnalyzer {

    private  String message;

    public MoodAnalyzer(){
        message = "I am in sad mood";
    }
    public MoodAnalyzer(String message){
        this.message = message;
    }
    public String analyseMood(String message){
        this.message = message;
        return analyseMood();
    }
    public String analyseMood() {
        try {
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch(NullPointerException e){
            return "Invalid";

            }
    }


}
