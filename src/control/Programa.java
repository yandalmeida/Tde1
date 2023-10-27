package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.Conexao;
import model.Aluno;
import model.Curso;

public class Programa {
    public static void main(String[] args) {
        Connection connection = Conexao.conectar();
        if (connection == null) {
            System.out.println("Falha na conexão com o banco de dados.");
            return;
        }


        Curso curso = new Curso(1, "Curso de Java", 40);
        cadastrarCurso(connection, curso);


        Aluno aluno = new Aluno(1, "Brabo", 1);
        cadastrarAluno(connection, aluno);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarCurso(Connection connection, Curso curso) {
        try {
            String sql = "INSERT INTO curso (codigo, nome, carga_horaria) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, curso.getCodigo());
            preparedStatement.setString(2, curso.getNome());
            preparedStatement.setInt(3, curso.getCargaHoraria());
            int linhasAfetadas = preparedStatement.executeUpdate();
            preparedStatement.close();

            if (linhasAfetadas > 0) {
                System.out.println("Curso cadastrado com sucesso: Código " + curso.getCodigo() + ", Nome " + curso.getNome());
            } else {
                System.out.println("Falha ao cadastrar curso.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void cadastrarAluno(Connection connection, Aluno aluno) {
        try {
            String sql = "INSERT INTO aluno (matricula, nome, codigo_curso) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, aluno.getMatricula());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setInt(3, aluno.getCodigoCurso());
            int linhasAfetadas = preparedStatement.executeUpdate();
            preparedStatement.close();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno cadastrado com sucesso: Matrícula " + aluno.getMatricula() + ", Nome " + aluno.getNome());
            } else {
                System.out.println("Falha ao cadastrar aluno.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}