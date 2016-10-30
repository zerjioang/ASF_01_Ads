
/**
 * AdvertisementEndpointClassNotFoundExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

package grupo1.dao;

public class AdvertisementEndpointClassNotFoundExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1477847954758L;
    
    private grupo1.dao.AdvertisementEndpointClassNotFoundException faultMessage;

    
        public AdvertisementEndpointClassNotFoundExceptionException() {
            super("AdvertisementEndpointClassNotFoundExceptionException");
        }

        public AdvertisementEndpointClassNotFoundExceptionException(java.lang.String s) {
           super(s);
        }

        public AdvertisementEndpointClassNotFoundExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public AdvertisementEndpointClassNotFoundExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(grupo1.dao.AdvertisementEndpointClassNotFoundException msg){
       faultMessage = msg;
    }
    
    public grupo1.dao.AdvertisementEndpointClassNotFoundException getFaultMessage(){
       return faultMessage;
    }
}
    