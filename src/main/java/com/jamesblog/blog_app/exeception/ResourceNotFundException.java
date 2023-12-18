package com.jamesblog.blog_app.exeception;

public class ResourceNotFundException extends RuntimeException{
    String ResourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s :%d",resourceName,fieldName,fieldValue));
        ResourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
