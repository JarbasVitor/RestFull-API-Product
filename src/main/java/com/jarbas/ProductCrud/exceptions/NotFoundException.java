package com.jarbas.ProductCrud.exceptions;


import java.util.UUID;


public class NotFoundException extends RuntimeException{

    public NotFoundException(UUID id){
        super("Entity: " + id +" Not FOUND!");
    }
}
