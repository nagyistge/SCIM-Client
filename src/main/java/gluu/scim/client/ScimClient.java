/*
 * SCIM-Client is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2014, Gluu
 */
package gluu.scim.client;

import gluu.scim.client.auth.UmaScimClientImpl;
import gluu.scim.client.model.ScimBulkOperation;
import gluu.scim.client.model.ScimGroup;
import gluu.scim.client.model.ScimPerson;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBException;

import org.xdi.oxauth.model.util.SecurityProviderUtility;

/**
 * SCIM Client
 * 
 * @author Reda Zerrad Date: 05.24.2012
 * @author Yuriy Movchan Date: 08/08/2013
 */
public class ScimClient implements BaseScimClient, Serializable {

	private static final long serialVersionUID = 5919055665311654721L;
	
	private BaseScimClient scimClient;

	public static ScimClient umaInstance(String domain, String umaMetaDataUrl, String umaAatClientId, String umaAatClientJksPath, String umaAatClientJksPassword, String umaAatClientKeyId) {
    	SecurityProviderUtility.installBCProvider();
		BaseScimClient baseClient = new UmaScimClientImpl(domain, umaMetaDataUrl, umaAatClientId, umaAatClientJksPath, umaAatClientJksPassword, umaAatClientKeyId); 
		return new ScimClient(baseClient);
	}

	public ScimClient(BaseScimClient baseClient) {
		this.scimClient = baseClient;
	}

	/*
	 * @see gluu.scim.client.ScimClientService#retrievePerson(java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse retrievePerson(String uid, String mediaType) throws IOException {
		return scimClient.retrievePerson(uid, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#createPerson(gluu.scim.client.model.ScimPerson, java.lang.String)
	 */
	@Override
	public ScimResponse createPerson(ScimPerson person, String mediaType) throws IOException, JAXBException {
		return scimClient.createPerson(person, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#updatePerson(gluu.scim.client.model.ScimPerson, java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse updatePerson(ScimPerson person, String uid, String mediaType) throws IOException, JAXBException {
		return scimClient.updatePerson(person, uid, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#deletePerson(java.lang.String)
	 */
	@Override
	public ScimResponse deletePerson(String uid) throws IOException {
		return scimClient.deletePerson(uid);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#retrieveGroup(java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse retrieveGroup(String id, String mediaType) throws IOException {
		return scimClient.retrieveGroup(id, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#createGroup(gluu.scim.client.model.ScimGroup, java.lang.String)
	 */
	@Override
	public ScimResponse createGroup(ScimGroup group, String mediaType) throws IOException, JAXBException {
		return scimClient.createGroup(group, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#updateGroup(gluu.scim.client.model.ScimGroup, java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse updateGroup(ScimGroup group, String id, String mediaType) throws IOException, JAXBException {
		return scimClient.updateGroup(group, id, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#deleteGroup(java.lang.String)
	 */
	@Override
	public ScimResponse deleteGroup(String id) throws IOException {
		return scimClient.deleteGroup(id);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#createPersonString(java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse createPersonString(String person, String mediaType) throws IOException, JAXBException {
		return scimClient.createPersonString(person, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#updatePersonString(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse updatePersonString(String person, String uid, String mediaType) throws IOException, JAXBException {
		return scimClient.updatePersonString(person, uid, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#createGroupString(java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse createGroupString(String group, String mediaType) throws IOException, JAXBException {
		return scimClient.createGroupString(group, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#updateGroupString(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse updateGroupString(String group, String id, String mediaType) throws IOException, JAXBException {
		return scimClient.updateGroupString(group, id, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#bulkOperation(gluu.scim.client.model.ScimBulkOperation, java.lang.String)
	 */
	@Override
	public ScimResponse bulkOperation(ScimBulkOperation operation, String mediaType) throws IOException, JAXBException {
		return scimClient.bulkOperation(operation, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#bulkOperationString(java.lang.String, java.lang.String)
	 */
	@Override
	public ScimResponse bulkOperationString(String operation, String mediaType) throws IOException {
		return scimClient.bulkOperationString(operation, mediaType);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#retrieveAllPersons()
	 */
	@Override
	public ScimResponse retrieveAllPersons() throws IOException {
		return scimClient.retrieveAllPersons();
	}

	/**
	 * Person search via a filter with pagination and sorting
	 *
	 * @param filter
	 * @param startIndex
	 * @param count
	 * @param sortBy
	 * @param sortOrder
	 * @param attributesArray
	 * @return ScimResponse
	 * @throws IOException
	 */
	@Override
	public ScimResponse searchPersons(String filter, int startIndex, int count, String sortBy, String sortOrder, String[] attributesArray) throws IOException {
		return scimClient.searchPersons(filter, startIndex, count, sortBy, sortOrder, attributesArray);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#retrieveAllGroups()
	 */
	@Override
	public ScimResponse retrieveAllGroups() throws IOException {
		return scimClient.retrieveAllGroups();
	}

	/**
	 * Group search via a filter with pagination and sorting
	 *
	 * @param filter
	 * @param startIndex
	 * @param count
	 * @param sortBy
	 * @param sortOrder
	 * @param attributesArray
	 * @return ScimResponse
	 * @throws IOException
	 */
	@Override
	public ScimResponse searchGroups(String filter, int startIndex, int count, String sortBy, String sortOrder, String[] attributesArray) throws IOException {
		return scimClient.searchGroups(filter, startIndex, count, sortBy, sortOrder, attributesArray);
	}

	/*
	 * @see gluu.scim.client.ScimClientService#personSearch(java.lang.String, java.lang.String, java.lang.String)
	 */
	/*
	@Override
	public ScimResponse personSearch(String attribute, String value, String mediaType) throws IOException, JAXBException {
		return scimClient.personSearch(attribute, value, mediaType);
	}
	*/

	/*
	 * @see gluu.scim.client.ScimClientService#personSearchByObject(java.lang.String, java.lang.Object, java.lang.String, java.lang.String)
	 */
	/*
	@Override
	public ScimResponse personSearchByObject(String attribute, Object value, String valueMediaType, String outPutMediaType)	throws IOException, JAXBException {
		return scimClient.personSearchByObject(attribute, value, valueMediaType, outPutMediaType);
	}
	*/

	/*
	 * @see gluu.scim.client.ScimClientService#searchPersons(java.lang.String, java.lang.String, java.lang.String)
	 */
	/*
	@Override
	public ScimResponse searchPersons(String attribute, String value, String mediaType) throws IOException, JAXBException {
		return scimClient.searchPersons(attribute, value, mediaType);
	}
	*/
}
