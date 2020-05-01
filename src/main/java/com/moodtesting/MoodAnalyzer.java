package com.moodtesting;

import java.util.Objects;

public class MoodAnalyzer {

    private String message;

    //Refactor In UC1 after TC-1.2
    public MoodAnalyzer(){
    }
    //Refactor In UC1 after TC-1.2
    public MoodAnalyzer(String message){
        this.message = message;
    }
    public String analyseMood(String message) throws MoodAnalysisException {                           //UC-2 Handle exception
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
    public String analyseMood() throws MoodAnalysisException {
        return analyseMood(this.message);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }
    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
