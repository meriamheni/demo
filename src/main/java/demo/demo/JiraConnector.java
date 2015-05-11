package demo.demo;

import java.net.URI;
import java.util.Iterator;

import org.joda.time.DateTime;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.input.VersionInput;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

public class JiraConnector {

	private static final URI JIRA_SERVER_URI = URI.create("http://localhost:8080");
	private static final String USERNAME = "meriamhenine@hotmail.com";
	private static final String PASSWORD = "12345678";
	
	public static void main(String[] args) {
		
		//create the client
		JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		JiraRestClient restClient = factory.createWithBasicHttpAuthentication(JIRA_SERVER_URI, USERNAME, PASSWORD);
		
		//get all projects
		Iterator<BasicProject> it = restClient.getProjectClient().getAllProjects().claim().iterator();
		while (it.hasNext()) {
			BasicProject basicProject = (BasicProject) it.next();
			System.out.println(basicProject.getName());
		}
		
		//create new version
		VersionInput v = new VersionInput("ANT", "patate", " description ", 
				new DateTime(), true, true);
		restClient.getVersionRestClient().createVersion(v).claim();

	}
	
}
