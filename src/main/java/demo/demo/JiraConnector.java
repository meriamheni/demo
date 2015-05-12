package demo.demo;

import java.net.URI;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

public class JiraConnector {

	private static final URI JIRA_SERVER_URI = URI.create("http://localhost:8080");
	private static final String USERNAME = "meriamhenine@hotmail.com";
	private static final String PASSWORD = "12345678";
	
	public static JiraRestClient createRestClient(){
		JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		JiraRestClient restClient = factory.createWithBasicHttpAuthentication(JIRA_SERVER_URI, USERNAME, PASSWORD);
		return restClient;
	}	
}
