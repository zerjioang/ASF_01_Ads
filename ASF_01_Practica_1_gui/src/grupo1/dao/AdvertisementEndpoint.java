

/**
 * AdvertisementEndpoint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

    package grupo1.dao;

    /*
     *  AdvertisementEndpoint java interface
     */

    public interface AdvertisementEndpoint {
          

        /**
          * Auto generated method signature
          * 
                    * @param deleteCategory9
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteCategory(

                        grupo1.dao.DeleteCategory deleteCategory9)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteCategory9
            
          */
        public void startdeleteCategory(

            grupo1.dao.DeleteCategory deleteCategory9,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCategory11
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetCategoryResponse getCategory(

                        grupo1.dao.GetCategory getCategory11)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCategory11
            
          */
        public void startgetCategory(

            grupo1.dao.GetCategory getCategory11,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateUser13
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateUser(

                        grupo1.dao.UpdateUser updateUser13)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateUser13
            
          */
        public void startupdateUser(

            grupo1.dao.UpdateUser updateUser13,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateAdvertisement15
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateAdvertisement(

                        grupo1.dao.UpdateAdvertisement updateAdvertisement15)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateAdvertisement15
            
          */
        public void startupdateAdvertisement(

            grupo1.dao.UpdateAdvertisement updateAdvertisement15,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateCategory17
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateCategory(

                        grupo1.dao.UpdateCategory updateCategory17)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateCategory17
            
          */
        public void startupdateCategory(

            grupo1.dao.UpdateCategory updateCategory17,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUser19
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetUserResponse getUser(

                        grupo1.dao.GetUser getUser19)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUser19
            
          */
        public void startgetUser(

            grupo1.dao.GetUser getUser19,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByCategory21
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsByCategoryResponse getAdsByCategory(

                        grupo1.dao.GetAdsByCategory getAdsByCategory21)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByCategory21
            
          */
        public void startgetAdsByCategory(

            grupo1.dao.GetAdsByCategory getAdsByCategory21,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAd23
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdResponse getAd(

                        grupo1.dao.GetAd getAd23)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAd23
            
          */
        public void startgetAd(

            grupo1.dao.GetAd getAd23,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param conectar25
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void conectar(

                        grupo1.dao.Conectar conectar25)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param conectar25
            
          */
        public void startconectar(

            grupo1.dao.Conectar conectar25,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param desconectar27
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void desconectar(

                        grupo1.dao.Desconectar desconectar27)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param desconectar27
            
          */
        public void startdesconectar(

            grupo1.dao.Desconectar desconectar27,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteUser29
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteUser(

                        grupo1.dao.DeleteUser deleteUser29)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteUser29
            
          */
        public void startdeleteUser(

            grupo1.dao.DeleteUser deleteUser29,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUsers31
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetUsersResponse getUsers(

                        grupo1.dao.GetUsers getUsers31)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUsers31
            
          */
        public void startgetUsers(

            grupo1.dao.GetUsers getUsers31,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertAd33
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertAdResponse insertAd(

                        grupo1.dao.InsertAd insertAd33)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertAd33
            
          */
        public void startinsertAd(

            grupo1.dao.InsertAd insertAd33,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertCategory35
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertCategoryResponse insertCategory(

                        grupo1.dao.InsertCategory insertCategory35)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertCategory35
            
          */
        public void startinsertCategory(

            grupo1.dao.InsertCategory insertCategory35,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCategories37
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetCategoriesResponse getCategories(

                        grupo1.dao.GetCategories getCategories37)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCategories37
            
          */
        public void startgetCategories(

            grupo1.dao.GetCategories getCategories37,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteAd39
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteAd(

                        grupo1.dao.DeleteAd deleteAd39)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteAd39
            
          */
        public void startdeleteAd(

            grupo1.dao.DeleteAd deleteAd39,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByUser41
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsByUserResponse getAdsByUser(

                        grupo1.dao.GetAdsByUser getAdsByUser41)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByUser41
            
          */
        public void startgetAdsByUser(

            grupo1.dao.GetAdsByUser getAdsByUser41,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAds43
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsResponse getAds(

                        grupo1.dao.GetAds getAds43)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAds43
            
          */
        public void startgetAds(

            grupo1.dao.GetAds getAds43,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertUser45
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertUserResponse insertUser(

                        grupo1.dao.InsertUser insertUser45)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertUser45
            
          */
        public void startinsertUser(

            grupo1.dao.InsertUser insertUser45,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param changeCategory47
                
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void changeCategory(

                        grupo1.dao.ChangeCategory changeCategory47)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param changeCategory47
            
          */
        public void startchangeCategory(

            grupo1.dao.ChangeCategory changeCategory47,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    