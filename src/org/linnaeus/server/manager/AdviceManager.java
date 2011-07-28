package org.linnaeus.server.manager;

import org.linnaeus.server.bean.Advice;
import org.linnaeus.server.bean.AdviceRequest;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 28/07/11
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public class AdviceManager {

    private static AdviceManager instance = new AdviceManager();

    private AdviceManager(){

    }

    public static AdviceManager getInstance(){
        return instance;
    }

    public ArrayList<Advice> acquireAdvices(AdviceRequest adviceRequest){
		RequestManager requestManager = RequestManager.getInstance();
        return requestManager.getAdvicesByAdviceRequest(adviceRequest);
    }
}
