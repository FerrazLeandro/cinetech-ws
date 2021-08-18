package br.com.cinetech.cinetechws.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cinetech.cinetechws.model.Filme;
import br.com.cinetech.cinetechws.repository.FilmeRepository;
import br.com.cinetech.cinetechws.shared.FilmeDto;

@Service
public class FilmeServiceImpl implements FilmeService{
    @Autowired
    FilmeRepository repo; 

    @Override
    public List<FilmeDto> listarFilmes() {
       List<Filme> filmes = repo.findAll();

       return filmes.stream().map(f -> new ModelMapper().map(f, FilmeDto.class)).collect(Collectors.toList());
    }

    @Override
    public FilmeDto cadastrarFilme(FilmeDto filme) {
       Filme filmeParaGravar = new ModelMapper().map(filme, Filme.class);
       filmeParaGravar = repo.save(filmeParaGravar);
       
       return new ModelMapper().map(filmeParaGravar, FilmeDto.class);
    }

   @Override
   public Optional<FilmeDto> atualizarFilme(String id, FilmeDto filme) {
      Optional<Filme> filmeBanco = repo.findById(id);

      if (filmeBanco.isPresent()){
         Filme filmeParaAtualizar = new ModelMapper().map(filme, Filme.class);
         filmeParaAtualizar.setId(id);
         filmeParaAtualizar = repo.save(filmeParaAtualizar);
         return Optional.of(new ModelMapper().map(filmeParaAtualizar, FilmeDto.class));
      }
      return Optional.empty();
   }

   @Override
   public void excluirFilmePorId(String id) {
      repo.deleteById(id);
      
   }
    
}
