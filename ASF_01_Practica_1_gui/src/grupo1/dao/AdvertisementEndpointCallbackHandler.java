
/**
 * AdvertisementEndpointCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

    package grupo1.dao;

    /**
     *  AdvertisementEndpointCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AdvertisementEndpointCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AdvertisementEndpointCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AdvertisementEndpointCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for deleteCategory method
            * override this method for handling normal response from deleteCategory operation
            */
           public void receiveResultdeleteCategory(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteCategory operation
           */
            public void receiveErrordeleteCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCategory method
            * override this method for handling normal response from getCategory operation
            */
           public void receiveResultgetCategory(
                    grupo1.dao.GetCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCategory operation
           */
            public void receiveErrorgetCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateUser method
            * override this method for handling normal response from updateUser operation
            */
           public void receiveResultupdateUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateUser operation
           */
            public void receiveErrorupdateUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateAdvertisement method
            * override this method for handling normal response from updateAdvertisement operation
            */
           public void receiveResultupdateAdvertisement(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateAdvertisement operation
           */
            public void receiveErrorupdateAdvertisement(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateCategory method
            * override this method for handling normal response from updateCategory operation
            */
           public void receiveResultupdateCategory(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateCategory operation
           */
            public void receiveErrorupdateCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUser method
            * override this method for handling normal response from getUser operation
            */
           public void receiveResultgetUser(
                    grupo1.dao.GetUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUser operation
           */
            public void receiveErrorgetUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdsByCategory method
            * override this method for handling normal response from getAdsByCategory operation
            */
           public void receiveResultgetAdsByCategory(
                    grupo1.dao.GetAdsByCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdsByCategory operation
           */
            public void receiveErrorgetAdsByCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAd method
            * override this method for handling normal response from getAd operation
            */
           public void receiveResultgetAd(
                    grupo1.dao.GetAdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAd operation
           */
            public void receiveErrorgetAd(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdsByQueryOnName method
            * override this method for handling normal response from getAdsByQueryOnName operation
            */
           public void receiveResultgetAdsByQueryOnName(
                    grupo1.dao.GetAdsByQueryOnNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdsByQueryOnName operation
           */
            public void receiveErrorgetAdsByQueryOnName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteUser method
            * override this method for handling normal response from deleteUser operation
            */
           public void receiveResultdeleteUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteUser operation
           */
            public void receiveErrordeleteUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUsers method
            * override this method for handling normal response from getUsers operation
            */
           public void receiveResultgetUsers(
                    grupo1.dao.GetUsersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUsers operation
           */
            public void receiveErrorgetUsers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertAd method
            * override this method for handling normal response from insertAd operation
            */
           public void receiveResultinsertAd(
                    grupo1.dao.InsertAdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertAd operation
           */
            public void receiveErrorinsertAd(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertCategory method
            * override this method for handling normal response from insertCategory operation
            */
           public void receiveResultinsertCategory(
                    grupo1.dao.InsertCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertCategory operation
           */
            public void receiveErrorinsertCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCategories method
            * override this method for handling normal response from getCategories operation
            */
           public void receiveResultgetCategories(
                    grupo1.dao.GetCategoriesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCategories operation
           */
            public void receiveErrorgetCategories(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteAd method
            * override this method for handling normal response from deleteAd operation
            */
           public void receiveResultdeleteAd(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAd operation
           */
            public void receiveErrordeleteAd(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdsByUser method
            * override this method for handling normal response from getAdsByUser operation
            */
           public void receiveResultgetAdsByUser(
                    grupo1.dao.GetAdsByUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdsByUser operation
           */
            public void receiveErrorgetAdsByUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAds method
            * override this method for handling normal response from getAds operation
            */
           public void receiveResultgetAds(
                    grupo1.dao.GetAdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAds operation
           */
            public void receiveErrorgetAds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteSchema method
            * override this method for handling normal response from deleteSchema operation
            */
           public void receiveResultdeleteSchema(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteSchema operation
           */
            public void receiveErrordeleteSchema(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertUser method
            * override this method for handling normal response from insertUser operation
            */
           public void receiveResultinsertUser(
                    grupo1.dao.InsertUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertUser operation
           */
            public void receiveErrorinsertUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeCategory method
            * override this method for handling normal response from changeCategory operation
            */
           public void receiveResultchangeCategory(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeCategory operation
           */
            public void receiveErrorchangeCategory(java.lang.Exception e) {
            }
                


    }
    