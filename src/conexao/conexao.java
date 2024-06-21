package com.mycompany.jogo.Telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/usuarios";
    private static final String user = "Root";
    private static final String passorwd = "1234";


    private static Connection conn;

    public static Connection getConexao(){

        try{
        if (conn = null){
            conn = DriverManager.getConnection(url, user, passorwd);
            return conn;

        } else {
            return conn;
        }
        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    
}
}
