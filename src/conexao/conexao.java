package com.mycompany.jogo.Telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    private static final String url = "jdbc:mysql://localhost:3306/usuarios";
    private static final String user = "Root";
    private static final String passorwd = "1234";

    private ConexaoBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Falha na conexão!");
            e.printStackTrace();
        }
    }

    public static ConexaoBD getInstance() {
        if (instance == null) {
            instance = new ConexaoBD();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void executarSQL(String sql) { // caso queira executar um comando
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Comando SQL executado com sucesso: " + sql);
        } catch (SQLException e) {
            System.out.println("Erro ao executar o comando SQL: " + sql);
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ResultSet executarConsulta(String sql) { // caso queira executar uma cosulta ao banco de dados
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta SQL: " + sql);
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConDB() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
    }
}