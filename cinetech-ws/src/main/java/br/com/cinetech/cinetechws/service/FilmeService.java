package br.com.cinetech.cinetechws.service;
import java.util.List;
import java.util.Optional;
import br.com.cinetech.cinetechws.shared.FilmeDto;

public interface FilmeService {
    List<FilmeDto> listarFilmes();
    FilmeDto cadastrarFilme(FilmeDto filme);
    Optional<FilmeDto> atualizarFilme(String id, FilmeDto filme);
    void excluirFilmePorId(String id);
}
