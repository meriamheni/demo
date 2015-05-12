package demo.demo;

import java.net.URI;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Version;
import com.atlassian.jira.rest.client.api.domain.input.VersionInput;

public class JiraVersionImpl implements JiraVersion{

	private static final String URI_VERSION_PATTERN = "http://localhost:8080/rest/api/latest/version/";
	
	public Version createVersion(VersionInput versionInput) throws Exception {
		JiraRestClient restClient = null;
		Version version = null;
		try {
			restClient = JiraConnector.createRestClient();
			version = restClient.getVersionRestClient().createVersion(versionInput).claim();
		} finally {
			if (restClient != null) {
				restClient.close();
			}
		}
		return version;
	}

	public Version updateVersion(VersionInput versionInput, Long id) throws Exception {
		JiraRestClient restClient = null;
		Version version = null;
		try {
			restClient = JiraConnector.createRestClient();
			version = restClient.getVersionRestClient().updateVersion(getUriVersion(id), versionInput).claim();
		} finally {
			if (restClient != null) {
				restClient.close();
			}
		}
		return version;
	}

	public void deleteVersion(Long id) throws Exception {
		JiraRestClient restClient = null;
		try {
			restClient = JiraConnector.createRestClient();
			restClient.getVersionRestClient().removeVersion(getUriVersion(id), null, null).claim();
		} finally {
			if (restClient != null) {
				restClient.close();
			}
		}
	}	
	
	private URI getUriVersion(Long id) {
		return URI.create(URI_VERSION_PATTERN + id);
	}
	
}
