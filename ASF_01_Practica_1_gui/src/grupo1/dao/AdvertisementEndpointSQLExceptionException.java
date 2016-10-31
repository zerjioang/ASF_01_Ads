
/**
 * AdvertisementEndpointSQLExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

package grupo1.dao;

public class AdvertisementEndpointSQLExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1477911343284L;
    
    private grupo1.dao.AdvertisementEndpointSQLException faultMessage;

    
        public AdvertisementEndpointSQLExceptionException() {
            super("AdvertisementEndpointSQLExceptionException");
        }

        public AdvertisementEndpointSQLExceptionException(java.lang.String s) {
           super(s);
        }

        public AdvertisementEndpointSQLExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public AdvertisementEndpointSQLExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(grupo1.dao.AdvertisementEndpointSQLException msg){
       faultMessage = msg;
    }
    
    public grupo1.dao.AdvertisementEndpointSQLException getFaultMessage(){
       return faultMessage;
    }
}
    