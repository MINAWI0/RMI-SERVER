package org.example.service;

import org.example.models.Books;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BookService extends Remote {
    List<Books> getAllBooks() throws  RemoteException;
    Books getBookByName(String name) throws RemoteException;

}
