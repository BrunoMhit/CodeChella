package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.888-88","João", LocalDate.parse("2000-10-15"),"Joao@email.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.888-88","maria", LocalDate.parse("2000-10-15"),"maria@email.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.888-88","vinicius", LocalDate.parse("2000-10-15"),"vinicius@email.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.888-88","rafael", LocalDate.parse("2000-10-15"),"rafael@email.com"));

        //System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");
    }
}
