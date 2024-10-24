package org.example;

import org.example.service.BookService;
import org.example.service.Impl.BookServiceImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry();
            BookServiceImpl bookService = new BookServiceImpl();
            BookService serverStub = (BookService) UnicastRemoteObject.exportObject(bookService,0);
            registry.rebind("BookServiceImpl" ,  serverStub);
            System.out.println("server is running");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
