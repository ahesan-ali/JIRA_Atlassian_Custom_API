package com.jira.genai.jira.service;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestTemplateHttpClient {

    @Value("${jira-api.url}")
    String jiraUrl;
    @Value("${jira-api.token}")
    String apiKey;

    public HttpResponse<JsonNode> getResponseByIssueType(String issueType) {
        try {
            return Unirest.get(jiraUrl + issueType).header("Accept", "application/json")
                    .header("Authorization", "Basic " + apiKey).asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<JsonNode> getAllIssues() {
        try {
            return Unirest.get(getIssueKeyUrl(jiraUrl) + "search").header("Accept", "application/json")
                    .header("Authorization", "Basic " + apiKey).asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<JsonNode> getIssueByKey(String issueKey) {
        try {
            return Unirest.get(getIssueKeyUrl(jiraUrl).concat("issue") + "/" + issueKey).header("Accept", "application/json")
                    .header("Authorization", "Basic " + apiKey).asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    private String getSearchAllUrl(String jiraUrl) {
        return jiraUrl.substring(0, jiraUrl.indexOf("?"));
    }

    private String getIssueKeyUrl(String jiraUrl) {
        return jiraUrl.substring(0, jiraUrl.indexOf("search"));
    }

    public static void main(String[] args) {
        String url = "https://ahsanalinuk.atlassian.net/rest/api/2/search?jql=issueType=";
        String j = url.substring(0, url.indexOf("search")).concat("issue");
        System.out.println(j);

    }
    /*HttpResponse<JsonNode> response = Unirest.get(searchByDefects)
            .header("Accept", "application/json")
            .header("Authorization", "Basic " + jiraApiKey)
            .asJson();
    String jiraIssueResponse = response.getBody().getObject().toString(2);*/
}
