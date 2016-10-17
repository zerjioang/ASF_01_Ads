package grupo1.dao;

import java.util.ArrayList;

import grupo1.dto.*;

public class GestorBD {
	public static void main(String args[]) {
        System.out.println("Hello world!");
    }

    public ArrayList<Advertisement> getAdsByCategory(Category c) {
        ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        return ads;
    }

    public ArrayList<Advertisement> getAdsByUser(User u) {
        ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        return ads;
    }

    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();
        return categories;
    }

    public ArrayList<Advertisement> getAllAds() {
        ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        return ads;
    }

    public void deleteAd(Advertisement a) {

    }

    public void deleteCategory(Category c) {

    }

    public void deleteUser(User u) {

    }

    public void insertUser(User u) {

    }

    public void insertCategory(Category c) {

    }

    public void insertAd(Advertisement a) {

    }

    public void changeCategory(Advertisement a, Category c) {

    }
}
