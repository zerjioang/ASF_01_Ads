

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
                    * @param deleteCategory7
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteCategory(

                        grupo1.dao.DeleteCategory deleteCategory7)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteCategory7
            
          */
        public void startdeleteCategory(

            grupo1.dao.DeleteCategory deleteCategory7,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCategory9
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetCategoryResponse getCategory(

                        grupo1.dao.GetCategory getCategory9)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCategory9
            
          */
        public void startgetCategory(

            grupo1.dao.GetCategory getCategory9,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateUser11
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateUser(

                        grupo1.dao.UpdateUser updateUser11)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateUser11
            
          */
        public void startupdateUser(

            grupo1.dao.UpdateUser updateUser11,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateAdvertisement13
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateAdvertisement(

                        grupo1.dao.UpdateAdvertisement updateAdvertisement13)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateAdvertisement13
            
          */
        public void startupdateAdvertisement(

            grupo1.dao.UpdateAdvertisement updateAdvertisement13,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateCategory15
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void updateCategory(

                        grupo1.dao.UpdateCategory updateCategory15)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateCategory15
            
          */
        public void startupdateCategory(

            grupo1.dao.UpdateCategory updateCategory15,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUser17
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetUserResponse getUser(

                        grupo1.dao.GetUser getUser17)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUser17
            
          */
        public void startgetUser(

            grupo1.dao.GetUser getUser17,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByCategory19
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsByCategoryResponse getAdsByCategory(

                        grupo1.dao.GetAdsByCategory getAdsByCategory19)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByCategory19
            
          */
        public void startgetAdsByCategory(

            grupo1.dao.GetAdsByCategory getAdsByCategory19,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAd21
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdResponse getAd(

                        grupo1.dao.GetAd getAd21)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAd21
            
          */
        public void startgetAd(

            grupo1.dao.GetAd getAd21,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByQueryOnName23
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsByQueryOnNameResponse getAdsByQueryOnName(

                        grupo1.dao.GetAdsByQueryOnName getAdsByQueryOnName23)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByQueryOnName23
            
          */
        public void startgetAdsByQueryOnName(

            grupo1.dao.GetAdsByQueryOnName getAdsByQueryOnName23,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteUser25
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteUser(

                        grupo1.dao.DeleteUser deleteUser25)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteUser25
            
          */
        public void startdeleteUser(

            grupo1.dao.DeleteUser deleteUser25,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUsers27
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetUsersResponse getUsers(

                        grupo1.dao.GetUsers getUsers27)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUsers27
            
          */
        public void startgetUsers(

            grupo1.dao.GetUsers getUsers27,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertAd29
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertAdResponse insertAd(

                        grupo1.dao.InsertAd insertAd29)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertAd29
            
          */
        public void startinsertAd(

            grupo1.dao.InsertAd insertAd29,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertCategory31
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertCategoryResponse insertCategory(

                        grupo1.dao.InsertCategory insertCategory31)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertCategory31
            
          */
        public void startinsertCategory(

            grupo1.dao.InsertCategory insertCategory31,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCategories33
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetCategoriesResponse getCategories(

                        grupo1.dao.GetCategories getCategories33)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCategories33
            
          */
        public void startgetCategories(

            grupo1.dao.GetCategories getCategories33,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteAd35
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void deleteAd(

                        grupo1.dao.DeleteAd deleteAd35)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteAd35
            
          */
        public void startdeleteAd(

            grupo1.dao.DeleteAd deleteAd35,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAdsByUser37
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsByUserResponse getAdsByUser(

                        grupo1.dao.GetAdsByUser getAdsByUser37)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAdsByUser37
            
          */
        public void startgetAdsByUser(

            grupo1.dao.GetAdsByUser getAdsByUser37,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAds39
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.GetAdsResponse getAds(

                        grupo1.dao.GetAds getAds39)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAds39
            
          */
        public void startgetAds(

            grupo1.dao.GetAds getAds39,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertUser41
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public grupo1.dao.InsertUserResponse insertUser(

                        grupo1.dao.InsertUser insertUser41)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertUser41
            
          */
        public void startinsertUser(

            grupo1.dao.InsertUser insertUser41,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param changeCategory43
                
             * @throws grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException : 
             * @throws grupo1.dao.AdvertisementEndpointSQLExceptionException : 
         */

         
                     public void changeCategory(

                        grupo1.dao.ChangeCategory changeCategory43)
                        throws java.rmi.RemoteException
             
          ,grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException
          ,grupo1.dao.AdvertisementEndpointSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param changeCategory43
            
          */
        public void startchangeCategory(

            grupo1.dao.ChangeCategory changeCategory43,

            final grupo1.dao.AdvertisementEndpointCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    