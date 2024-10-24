package org.example.service.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.example.models.Books;
import org.example.service.BookService;
import org.example.utils.DatabaseUtils;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Books> getAllBooks() throws  RemoteException {
        try (Connection conn = DatabaseUtils.getConnection()){
            QueryRunner runner = new QueryRunner();
            String query = "SELECT * FROM books";
            return runner.query(conn, query, new BeanListHandler<>(Books.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Books getBookByName(String name) throws  RemoteException {
        try (Connection conn = DatabaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            String query = "SELECT * FROM books WHERE name = ?";
            return runner.query(conn, query, new BeanListHandler<>(Books.class), name).get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
