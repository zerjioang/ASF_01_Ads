

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
                    * @param deleteCategory8
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteCategory(

                        grupo1.dao.DeleteCategory deleteCategory8)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteCategory8
            
          */
        public void startdeleteCategory(

            grupo1.dao.DeleteCategory deleteCategory8,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCategory10
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetCategoryResponse getCategory(

                        grupo1.dao.GetCategory getCategory10)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCategory10
            
          */
        public void startgetCategory(

            grupo1.dao.GetCategory getCategory10,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateUser12
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateUser(

                        grupo1.dao.UpdateUser updateUser12)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateUser12
            
          */
        public void startupdateUser(

            grupo1.dao.UpdateUser updateUser12,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateAdvertisement14
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateAdvertisement(

                        grupo1.dao.UpdateAdvertisement updateAdvertisement14)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateAdvertisement14
            
          */
        public void startupdateAdvertisement(

            grupo1.dao.UpdateAdvertisement updateAdvertisement14,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateCategory16
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateCategory(

                        grupo1.dao.UpdateCategory updateCategory16)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateCategory16
            
          */
        public void startupdateCategory(

            grupo1.dao.UpdateCategory updateCategory16,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUser18
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetUserResponse getUser(

                        grupo1.dao.GetUser getUser18)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUser18
            
          */
        public void startgetUser(

            grupo1.dao.GetUser getUser18,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByCategory20
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsByCategoryResponse getAdsByCategory(

                        grupo1.dao.GetAdsByCategory getAdsByCategory20)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByCategory20
            
          */
        public void startgetAdsByCategory(

            grupo1.dao.GetAdsByCategory getAdsByCategory20,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAd22
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdResponse getAd(

                        grupo1.dao.GetAd getAd22)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAd22
            
          */
        public void startgetAd(

            grupo1.dao.GetAd getAd22,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByQueryOnName24
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsByQueryOnNameResponse getAdsByQueryOnName(

                        grupo1.dao.GetAdsByQueryOnName getAdsByQueryOnName24)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByQueryOnName24
            
          */
        public void startgetAdsByQueryOnName(

            grupo1.dao.GetAdsByQueryOnName getAdsByQueryOnName24,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteUser26
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteUser(

                        grupo1.dao.DeleteUser deleteUser26)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteUser26
            
          */
        public void startdeleteUser(

            grupo1.dao.DeleteUser deleteUser26,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUsers28
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetUsersResponse getUsers(

                        grupo1.dao.GetUsers getUsers28)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUsers28
            
          */
        public void startgetUsers(

            grupo1.dao.GetUsers getUsers28,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertAd30
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertAdResponse insertAd(

                        grupo1.dao.InsertAd insertAd30)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertAd30
            
          */
        public void startinsertAd(

            grupo1.dao.InsertAd insertAd30,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertCategory32
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertCategoryResponse insertCategory(

                        grupo1.dao.InsertCategory insertCategory32)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertCategory32
            
          */
        public void startinsertCategory(

            grupo1.dao.InsertCategory insertCategory32,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCategories34
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetCategoriesResponse getCategories(

                        grupo1.dao.GetCategories getCategories34)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCategories34
            
          */
        public void startgetCategories(

            grupo1.dao.GetCategories getCategories34,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteAd36
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteAd(

                        grupo1.dao.DeleteAd deleteAd36)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteAd36
            
          */
        public void startdeleteAd(

            grupo1.dao.DeleteAd deleteAd36,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByUser38
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsByUserResponse getAdsByUser(

                        grupo1.dao.GetAdsByUser getAdsByUser38)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByUser38
            
          */
        public void startgetAdsByUser(

            grupo1.dao.GetAdsByUser getAdsByUser38,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAds40
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsResponse getAds(

                        grupo1.dao.GetAds getAds40)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAds40
            
          */
        public void startgetAds(

            grupo1.dao.GetAds getAds40,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteSchema42
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteSchema(

                        grupo1.dao.DeleteSchema deleteSchema42)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteSchema42
            
          */
        public void startdeleteSchema(

            grupo1.dao.DeleteSchema deleteSchema42,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertUser44
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertUserResponse insertUser(

                        grupo1.dao.InsertUser insertUser44)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertUser44
            
          */
        public void startinsertUser(

            grupo1.dao.InsertUser insertUser44,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param changeCategory46
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void changeCategory(

                        grupo1.dao.ChangeCategory changeCategory46)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param changeCategory46
            
          */
        public void startchangeCategory(

            grupo1.dao.ChangeCategory changeCategory46,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    