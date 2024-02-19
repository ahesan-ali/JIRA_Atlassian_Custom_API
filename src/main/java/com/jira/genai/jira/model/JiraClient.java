package com.jira.genai.jira.model;


public class JiraClient {
    private String username="ahsanalinuk@gmail.com";
    private String password="Jira@123";
    private String jiraUrl="https://ahsanalinuk.atlassian.net";


    /*public JiraClient(String username, String password, String jiraUrl) {
        this.username = username;
        this.password = password;
        this.jiraUrl = jiraUrl;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJiraUrl() {
        return jiraUrl;
    }

    public void setJiraUrl(String jiraUrl) {
        this.jiraUrl = jiraUrl;
    }
}
