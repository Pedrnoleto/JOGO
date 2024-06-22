package JOGO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Usuario;

public class UserDao {
    ConexaoBD conexao = ConexaoBD.getInstance();

    public void cadastarUsuario(int idade, String login, String senha) {
        String sql = "INSERT INTO usuarios (nome, idade, cidade, login, senha) VALUES ('" + login + ", '" + idade
                + "', '" + senha + "');";
        conexao.executarSQL(sql);
    }

    public boolean login(String login, String senha) throws SQLException {
        String sql = "SELECT login, senha FROM usuarios WHERE login = '" + login + "' and senha = '" + senha + "';";
        ResultSet resultado = null;
        resultado = conexao.executarConsulta(sql);
        if (resultado.next()) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<String> dadosUsuario(String login) {
        String sql = "SELECT id, idade FROM usuarios WHERE login = '" + login + "';";
        ResultSet result = null;
        int id = 0;
        int idade = 0;

        try {
            result = conexao.executarConsulta(sql);
            if (result.next()) {
                try {
                    id = result.getInt("id");
                    idade = result.getInt("idade");

                } catch (Exception e) {
                    System.out.println("Erro" + e.getMessage());
                }
            } else {
                System.out.println("erro");
            }
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        ArrayList<String> resultado = new ArrayList<>();
        resultado.add(Integer.toString(id));
        resultado.add(Integer.toString(idade));

        return resultado;
    }

}