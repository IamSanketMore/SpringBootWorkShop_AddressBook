package com.springbootworkshop.addressbookproject.exceptions;

public class ContactException extends RuntimeException
{
    public ContactException(String message)
    {
        super(message);
    }
}
