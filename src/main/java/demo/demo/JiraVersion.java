package demo.demo;

import com.atlassian.jira.rest.client.api.domain.Version;
import com.atlassian.jira.rest.client.api.domain.input.VersionInput;

public interface JiraVersion {

	Version createVersion(VersionInput versionInput) throws Exception;

	Version updateVersion(VersionInput version, Long id) throws Exception;

	void deleteVersion(Long id) throws Exception;
	
}
