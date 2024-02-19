package com.jira.genai.jira.service;

public interface JiraRestService {
    String getJiraDetailsByType(String issueType);

    String getAllIssues();

    String getIssueByKey(String issueKey);
}
