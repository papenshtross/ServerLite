package org.linnaeus.server.service;

import org.linnaeus.server.bean.Advice;
import org.linnaeus.server.bean.AdviceRequest;
import org.linnaeus.server.manager.AdviceManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 19/07/11
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
@Path("/advice")
public class AdviceService {

    @POST
	@Consumes( { MediaType.APPLICATION_JSON } )
    @Produces( { MediaType.APPLICATION_JSON } )
	public ArrayList<Advice> getAdvices(AdviceRequest adviceRequest) {
        System.out.println(adviceRequest);
        return AdviceManager.getInstance().acquireAdvices(adviceRequest);
	}
}
