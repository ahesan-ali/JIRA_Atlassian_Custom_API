package com.jira.genai.jira.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jira.genai.jira.exception.IssueNotFoundException;
import com.jira.genai.jira.service.JiraRestService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jira")
public class JiraRestClientController {

    @Autowired
    JiraRestService jiraRestService;

    @GetMapping(value = "/issueType/{issueType}")
    public ResponseEntity<String> getIssueByIssueType1(@PathVariable String issueType) throws JsonProcessingException, UnirestException {
        String response = jiraRestService.getJiraDetailsByType(issueType);
        if (response == null) {
            throw new IssueNotFoundException("issue= " + issueType);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> getAllIssues() {
        String issueResponse = jiraRestService.getAllIssues();
        if (issueResponse == null) {
            throw new IssueNotFoundException("All issue");
        }
        return ResponseEntity.status(HttpStatus.OK).body(issueResponse);
    }

    @GetMapping(value = "/issueKey/{issueKey}")
    public ResponseEntity<String> getIssueByKey1(@PathVariable String issueKey) {
        String response = jiraRestService.getIssueByKey(issueKey);
        if (response == null) {
            throw new IssueNotFoundException(issueKey);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
//findAll issues
//https://ahsanalinuk.atlassian.net/rest/api/2/search

// to find jira story by type task or bug ?
//https://ahsanalinuk.atlassian.net/rest/api/2/search?jql=issueType=task
//https://ahsanalinuk.atlassian.net/rest/api/2/search?jql=issueType=bug

//to find perticular issue
//https://ahsanalinuk.atlassian.net/rest/api/2/issue/SCRUM-1