package org.linnaeus.server.service;

import javax.ws.rs.Path;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 19/07/11
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
@Path("/advice")
public class AdviceService {

    // This method is called if XMLis request
	/*@GET
	@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Trends getXML() {
        return TrendManager.getInstance().acquireTrends();
	}

	// This can be used to test the integration with the browser
	@GET
	@Produces( { MediaType.TEXT_XML })
	public Trends getHTML() {
		return TrendManager.getInstance().acquireTrends();
	}*/
}
