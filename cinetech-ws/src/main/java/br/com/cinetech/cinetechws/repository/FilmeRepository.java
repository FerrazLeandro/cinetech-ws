package br.com.cinetech.cinetechws.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.cinetech.cinetechws.model.Filme;

public interface FilmeRepository extends MongoRepository<Filme, String>{
    
}
