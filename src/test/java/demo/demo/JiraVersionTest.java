package demo.demo;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import com.atlassian.jira.rest.client.api.domain.Version;
import com.atlassian.jira.rest.client.api.domain.input.VersionInput;

public class JiraVersionTest {

	JiraVersion service = new JiraVersionImpl();

	//@Test
	public void testCreateVersion() throws Exception {
		VersionInput versionInput = new VersionInput("ANT", "v1", "v1", new DateTime(), true, false);
		Version version = service.createVersion(versionInput);
		Assert.assertNotNull(version);
	}
	
	//@Test
	public void testUpdateVersion() throws Exception{
		final VersionInput versionInput = new VersionInput("ANT", "v1.1", "updated", new DateTime(), true, false);
		service.updateVersion(versionInput, 10102L);
		Assert.assertNotNull(versionInput);
	}

	@Test
	public void testDeleteVersion() throws Exception{
		service.deleteVersion(10102L);
	}

}
