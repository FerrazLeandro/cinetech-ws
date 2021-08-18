package br.com.cinetech.cinetechws.view.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinetech.cinetechws.service.FilmeService;
import br.com.cinetech.cinetechws.shared.FilmeDto;


@RestController
@RequestMapping("/api/filmes")
public class FilmeController {
    @Autowired
    FilmeService servico;

    @GetMapping
    public ResponseEntity<List<FilmeDto>> listarFilmes(){
        return new ResponseEntity<>(servico.listarFilmes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FilmeDto> criarFilme(@RequestBody @Valid FilmeDto filme){
        return new ResponseEntity<>(servico.cadastrarFilme(filme), HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity <FilmeDto> atualizarFilme(@PathVariable String id, @RequestBody @Valid FilmeDto filme) {
        Optional<FilmeDto> filmeParaAtualizar = servico.atualizarFilme(id, filme);    
        
        if (filmeParaAtualizar.isPresent()){
            return new ResponseEntity<>(filmeParaAtualizar.get(), HttpStatus.ACCEPTED); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> excluirFilmePorId(@PathVariable String id){
        servico.excluirFilmePorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }   
}
