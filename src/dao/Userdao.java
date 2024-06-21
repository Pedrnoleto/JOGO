import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Usuario;

public class Userdao {

    public void cadastrasUsuario(Usuario Uuario){

        String sql = "INSERT INTO USUARIO (LOGIN, SENHA, IDADE) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().PreparedStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getIdade());


            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
