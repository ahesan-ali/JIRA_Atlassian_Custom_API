This documentation pertains to a Spring Boot REST API application developed for the WeSynergize project "GenAI QEP Platform Development," specifically for the task titled "GenAI - Incorporate Dynamic Data Placeholders (2866)." The technologies utilized include Java 8, Spring Boot, JIRA Atlassian API, and IntelliJ IDEA.

As per discussions with Arora Maneesh, the requirement entails creating a JIRA account and utilizing the JIRA Atlassian API to retrieve issues through various methods such as by issue key or issue type.

Below are the API endpoints created:
1.	GET API - Fetch Issues by Type:
	•	Endpoint: localhost:8080/api/jira/issueType/bug
	•	Description: Retrieves all issues of a specified type, such as "bug" or "task."
2.	GET API - Fetch Specific Issue by Key or JIRA Name:
	•	Endpoint: localhost:8080/api/jira/issueKey/SCRUM-2
	•	Description: Retrieves a particular issue by its key or JIRA name.
3.	GET API - Fetch All Issues on JIRA Board:
	•	Endpoint: localhost:8080/api/jira/
	•	Description: Returns all issues present on the JIRA board.

links referred. 
https://developer.atlassian.com/server/jira/platform/jira-rest-api-examples/
