package org.linnaeus.server.service;

import org.linnaeus.server.bean.SearchCircle;
import org.linnaeus.server.bean.Trend;
import org.linnaeus.server.manager.TrendManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;


/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 18/07/11
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */

// POJO, no interface no extends

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/trends")
public class TrendsService {

    @POST
	@Consumes( { MediaType.APPLICATION_JSON } )
    @Produces( { MediaType.APPLICATION_JSON } )
	public ArrayList<Trend> getTrends(SearchCircle jsonSearchCircle) {
        return TrendManager.getInstance().acquireTrends(jsonSearchCircle);
	}

	// This method is called if XMLis request
	@GET
	@Produces( { MediaType.APPLICATION_XML })
	public ArrayList<Trend> getXML() {
        return TrendManager.getInstance().acquireTrends();
	}

	// This can be used to test the integration with the browser
	@GET
	@Produces( { MediaType.TEXT_XML })
	public ArrayList<Trend> getHTML() {
		return TrendManager.getInstance().acquireTrends();
	}
}
