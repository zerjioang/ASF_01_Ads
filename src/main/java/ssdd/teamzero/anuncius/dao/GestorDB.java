package ssdd.teamzero.anuncius.dao;

import ssdd.teamzero.anuncius.dao.dto.Anuncio;
import ssdd.teamzero.anuncius.dao.dto.Categoria;
import ssdd.teamzero.anuncius.dao.dto.Usuario;

import java.util.ArrayList;

public class GestorDB {

    public static void main(String args[]) {
        System.out.println("Hello world!");
    }

    public ArrayList<Anuncio> obtenerAnunciosPorCategoria(Categoria c) {
        ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
        return anuncios;
    }

    public ArrayList<Anuncio> obtenerAnunciosPorUsuario(Usuario u) {
        ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
        return anuncios;
    }

    public ArrayList<Categoria> obtenerCategorias() {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        return categorias;
    }

    public ArrayList<Anuncio> obtenerTodosLosAnuncios() {
        ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
        return anuncios;
    }

    public void borrarAnuncio(Anuncio a) {

    }

    public void borrarCategoria(Categoria c) {

    }

    public void borrarUsuario(Usuario u) {

    }

    public void insertarUsuario(Usuario u) {

    }

    public void insertarCategoria(Categoria c) {

    }

    public void insertarAnuncio(Anuncio a) {

    }

    public void cambiarCategoria(Anuncio a, Categoria c) {

    }
}