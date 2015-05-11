package demo.demo;

import java.net.URI;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Version;
import com.atlassian.jira.rest.client.api.domain.input.VersionInput;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final URI JIRA_SERVER_URI = URI.create("http://localhost:8080");
	private static final String USERNAME = "meriamhenine@hotmail.com";
	private static final String PASSWORD = "12345678";
	
	/**
	 * Create a JIRA REST client using user name and password for authentication.
	 * 
	 * @throws Exception
	 * @param username
	 * @param password
	 * @return JiraRestClient
	 * */
	public static JiraRestClient createRestClient(String username, String password) throws Exception {
		JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		JiraRestClient restClient = factory.createWithBasicHttpAuthentication(JIRA_SERVER_URI, username, password);
		return restClient;
	}
	
	/**
	 * Create new Jira version using VersionInput Object.
	 * 
	 * @throws Exception
	 * @param VersionInput
	 * @return Version
	 * */
	public Version createVersion(VersionInput versionInput) throws Exception {
		JiraRestClient restClient = null;
		Version version = null;
		try {
			restClient = createRestClient(USERNAME, PASSWORD);
			version = restClient.getVersionRestClient().createVersion(versionInput).claim();
		} finally {
			if (restClient != null) {
				restClient.close();
			}
		}
		return version;
	}
	
	// @Test
	public void testCreateVersion() throws Exception {
		VersionInput versionInput = new VersionInput("EUR", "ArchLinux", "winter", new DateTime(), true, false);
		Version version = createVersion(versionInput);
		Assert.assertNotNull(version);
	}
	
	@Test
	public void testAuthenticate() throws Exception {
		JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		JiraRestClient restClient = factory.createWithBasicHttpAuthentication(JIRA_SERVER_URI, USERNAME, PASSWORD);
	}

}
