/*
 * SCIM-Client is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2014, Gluu
 */
package gluu.scim.client;

import static org.testng.Assert.assertEquals;
import gluu.BaseScimTest;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * SCIM Client tests
 *
 * @author Reda Zerrad Date: 05.24.2012
 * @author Yuriy Movchan Date: 03/17/2016
 */
public class ScimClientRetreivingEntitiesTest extends BaseScimTest {

	private ScimClient client;

	@Parameters({ "domainURL", "umaMetaDataUrl", "umaAatClientId", "umaAatClientJksPath", "umaAatClientJksPassword" , "umaAatClientKeyId" })
	@BeforeTest
	public void init(final String domain, final String umaMetaDataUrl, final String umaAatClientId, final String umaAatClientJksPath, final String umaAatClientJksPassword, @Optional final String umaAatClientKeyId) throws IOException {
		client = ScimClient.umaInstance(domain, umaMetaDataUrl, umaAatClientId, umaAatClientJksPath, umaAatClientJksPassword, umaAatClientKeyId);
	}

	@Parameters({ "userInum" })
	@Test
	public void retrievePersonTest(final String uid) throws IOException {

		ScimResponse response = client.retrievePerson(uid, MediaType.APPLICATION_JSON);
		System.out.println("retrievePersonTest() response body = " + response.getResponseBodyString());
		assertEquals(response.getStatusCode(), 200, "Could not get the person, status != 200");
	}

	@Test
	public void retrieveAllPersonsTest() throws IOException {

		ScimResponse response = client.retrieveAllPersons();
		System.out.println("retrieveAllPersonsTest() response body = " + response.getResponseBodyString());
		assertEquals(response.getStatusCode(), 200, "Could not get a list of all persons, status != 200");
	}

	@Parameters({ "group1Inum" })
	@Test
	public void retrieveGroupTest(final String group1Inum) throws IOException {

		ScimResponse response = client.retrieveGroup(group1Inum, MediaType.APPLICATION_JSON);
		System.out.println("retrieveGroupTest() response body = " + response.getResponseBodyString());
		assertEquals(response.getStatusCode(), 200, "Could not get the group, status != 200");
	}

	@Test
	public void retrieveAllGroupsTest() throws IOException {

		ScimResponse response = client.retrieveAllGroups();
		System.out.println("retrieveAllGroupsTest() response body = " + response.getResponseBodyString());
		assertEquals(response.getStatusCode(), 200, "Could not get a list of all groups, status != 200");
	}
}
