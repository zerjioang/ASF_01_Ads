
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

        
            package grupo1.dao;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://dto.grupo1/xsd".equals(namespaceURI) &&
                  "Advertisement".equals(typeName)){
                   
                            return  grupo1.dto.xsd.Advertisement.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sql.java/xsd".equals(namespaceURI) &&
                  "SQLException".equals(typeName)){
                   
                            return  java.sql.xsd.SQLException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.grupo1/xsd".equals(namespaceURI) &&
                  "Category".equals(typeName)){
                   
                            return  grupo1.dto.xsd.Category.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.grupo1/xsd".equals(namespaceURI) &&
                  "User".equals(typeName)){
                   
                            return  grupo1.dto.xsd.User.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    