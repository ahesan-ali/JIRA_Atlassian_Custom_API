package com.jira.genai.jira.exception;

public class IssueNotFoundException extends RuntimeException{

    public IssueNotFoundException(String issue){
        super("could not find issue "+issue);
    }
}
