package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements ServerInterface{

    public int add(int num1 , int num2) {
        return num1 + num2;
    }

    public static void main(String[] args){
        try{
            Registry registry = LocateRegistry.getRegistry();
            Server server = new Server();
            ServerInterface serverStub = (ServerInterface) UnicastRemoteObject.exportObject(server,0);
            registry.rebind("server" ,  serverStub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
