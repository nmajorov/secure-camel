package biz.majorov.camel;

import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HeadersDynamicRouter {
	
	private static final Logger LOG = LoggerFactory.getLogger(HeadersDynamicRouter.class);
	
	public String routing(String body, @Header("X-MySpecialHeader") String specialHeader) {
		
		LOG.info("routing called  specialHeader: " + specialHeader);
		
        if (specialHeader == null) {
            return "direct:direct";
        } else  {
            return "direct:plus";
        }
       
    }

}
