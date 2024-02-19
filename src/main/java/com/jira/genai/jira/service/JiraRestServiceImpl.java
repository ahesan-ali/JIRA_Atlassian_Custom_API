package com.jira.genai.jira.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JiraRestServiceImpl implements JiraRestService {

    @Autowired
    RestTemplateHttpClient restTemplateHttpClient;

    @Override
    public String getJiraDetailsByType(String issueType) {
        return restTemplateHttpClient.getResponseByIssueType(issueType).getBody().getObject().toString(2);
    }

    @Override
    public String getAllIssues() {
        return restTemplateHttpClient.getAllIssues().getBody().getObject().toString(2);
    }

    @Override
    public String getIssueByKey(String issueKey) {
        return restTemplateHttpClient.getIssueByKey(issueKey).getBody().getObject().toString(2);
    }
}
