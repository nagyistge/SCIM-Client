package gluu.scim.client;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * SCIM UMA Client person Create,Update,Delete tests
 *
 * @author Reda Zerrad Date: 06.01.2012
 */
public class ScimClientPersonWriteOperationsUmaTest extends ScimClientPersonWriteOperationsBaseTest {

	@Parameters({ "domainURL", "umaMetaDataUrl", "umaAatClientId", "umaAatClientSecret" })
	@BeforeTest
	public void init(final String domain, final String umaMetaDataUrl, final String umaAatClientId, final String umaAatClientSecret) {
		client = ScimClient.umaInstance(domain, umaMetaDataUrl, umaAatClientId, umaAatClientSecret);
		response = null;
		person = null;
	}

}
