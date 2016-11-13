/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo1.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import grupo1.pojo.AdvertisementPOJO;
import grupo1.pojo.Advertisements;
import grupo1.pojo.Categories;
import grupo1.pojo.CategoryPOJO;
import grupo1.pojo.UserPOJO;
import grupo1.pojo.Users;
import grupo1.rest.response.ResponseType;
import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author .local
 */
@Path("public")
public class ApiResource {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;
    
    private final static Categories categoryList;
    private final static Users usersList;
    private final static Advertisements advertisementsList;

    static{
        categoryList = new Categories();
        usersList = new Users();
        advertisementsList = new Advertisements();
        
        //populate
        UserPOJO item = new UserPOJO(0, "Aitor", "email1@domain.com", "1234", new Date());
        UserPOJO item2 = new UserPOJO(1, "Sergio", "email2@domain.com", "Password", new Date());
        UserPOJO item3 = new UserPOJO(2, "Asier", "email3@domain.com", "123456", new Date());
        usersList.getUsers().add(item);
        usersList.getUsers().add(item2);
        usersList.getUsers().add(item3);
    }
    
    public ApiResource() {
    }
    
    //simple get method
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Api creada con jax-rs";
    }
    
    //CREATE METHODS
    
    @Path("/add/user/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUser(@PathParam("user") UserPOJO user) {
        if(user!=null){
            this.usersList.getUsers().add(user);
            return json(ResponseType.SUCCESS);
        }
        return json(ResponseType.ERROR);
    }
    
    @Path("/add/category/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCategory(@PathParam("category") CategoryPOJO category) {
        if(category!=null){
            this.categoryList.getCategories().add(category);
            return json(ResponseType.SUCCESS);
        }
        return json(ResponseType.ERROR);
    }
    
    @Path("/add/advertisement/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addAdvertisement(@PathParam("advertisement") AdvertisementPOJO advertisement) {
        if(advertisement!=null){
            this.advertisementsList.getAdvertisements().add(advertisement);
            return json(ResponseType.SUCCESS);
        }
        return json(ResponseType.ERROR);
    }
    
    //READ METHODS
    
    @Path("/read/advertisement/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdvertisement(@PathParam("id") int id) {
        if(id>0){
            AdvertisementPOJO ad = this.advertisementsList.getAdvertisements().get(id);
            if(ad!=null && ad.getId()==id){
                return json(ad);
            }
        }
        return json(ResponseType.ERROR);
    }
    
    @Path("/read/user/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("id") int id) {
        if(id>0){
            UserPOJO user = this.usersList.getUsers().get(id);
            if(user!=null && user.getId()==id){
                return json(user);
            }
        }
        return json(ResponseType.ERROR);
    }
    
    @Path("/read/category/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategory(@PathParam("id") int id) {
        if(id>0){
            CategoryPOJO cat = this.categoryList.getCategories().get(id);
            if(cat!=null && cat.getId()==id){
                return json(cat);
            }
        }
        return json(ResponseType.ERROR);
    }
    
    //UPDATE METHODS
    
    @Path("/update/user/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateUser(@PathParam("user") UserPOJO user) {
        return "{}";
    }
    
    @Path("/update/category/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCategory(@PathParam("category") CategoryPOJO category) {
        return "{}";
    }
    
    @Path("/update/advertisement/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateAdvertisement(@PathParam("advertisement") AdvertisementPOJO advertisement) {
        return "{}";
    }
    
    //DELETE METHODS
    
    @Path("/delete/advertisement/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteAdvertisement(@PathParam("id") int id) {
        AdvertisementPOJO ad = advertisementsList.getAdvertisements().remove(id);
        if(ad==null)
            return json(ResponseType.ERROR);
        else{
            return json(ResponseType.SUCCESS);
        }
    }
    
    @Path("/delete/user/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(@PathParam("id") int id) {
        UserPOJO user = usersList.getUsers().remove(id);
        System.out.println("Usuario eliminado: "+id);
        System.out.println("Quedan: "+usersList.getUsers().size()+" usuarios");
        if(user==null)
            return json(ResponseType.ERROR);
        else{
            return json(ResponseType.SUCCESS);
        }
    }
    
    @Path("/delete/category/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCategory(@PathParam("id") int id) {
        CategoryPOJO cat = categoryList.getCategories().remove(id);
        if(cat==null)
            return json(ResponseType.ERROR);
        else{
            return json(ResponseType.SUCCESS);
        }
    }
    
    //LIST METHODS
    
    @Path("/list/advertisements/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdvertisementist() {
        return json(advertisementsList.getAdvertisements());
    }
    
    @Path("/list/users/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserList() {
        return json(usersList.getUsers());
    }
    
    @Path("/list/categories/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategoryList() {
        return json(categoryList.getCategories());
    }
 
    //TEST METHOD

    @Path("/ping/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String zping() {
        return "API REST is working";
    }
    
    //HELPER METHODS

    private String json(Object object) {
        if(object==null){
            return "{}";
        }
        return GSON.toJson(object);
    }
}
