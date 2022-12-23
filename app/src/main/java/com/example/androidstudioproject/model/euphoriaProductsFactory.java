package com.example.androidstudioproject.model;

public class euphoriaProductsFactory {
    public iProductsDA getModel(){
        return new productsDataAccess();
    }
}
