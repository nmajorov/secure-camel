package biz.majorov.camel;

import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dynamic router class 
 * 
 * @author Nikolaj Majorov
 *
 */
public class HeadersDynamicRouter {
	
	private static final Logger LOG = LoggerFactory.getLogger(HeadersDynamicRouter.class);
	
	
	public String routing(@Header("X-MySpecialHeader") String specialHeader,
			@Header("parsed") Boolean parsed) {
		
		LOG.info("routing called  specialHeader: " + specialHeader);
		
		if (parsed != null && parsed == true){
		//	LOG .info("exchange: " + endpoint.createExchange());
			return null;
		}
        if (specialHeader == null) {
            return "direct:direct";
        } else  {
            return "direct:plus";
        }
       
    }

}
