package com.weslaapp.weslaapp.resources;

import com.weslaapp.weslaapp.models.Carro;
import com.weslaapp.weslaapp.repository.CarroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="/cars")
@Api(value="Wesla API")
@CrossOrigin(origins="*")
public class CarroResource {

    @Autowired
    CarroRepository carroRepository;

    @GetMapping("")
    @ApiOperation(value="Retorna uma lista de carros")
    public List<Carro> listaCarros(){
        return carroRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Retorna um carro por ID")
    public Carro listaCarroPorId(@PathVariable(value="id") long id){
        return carroRepository.findById(id);
    }

    @PostMapping("/new")
    @ApiOperation(value="Salva um carro")
    public Carro salvaCarro(@RequestBody Carro carro) {
        return carroRepository.save(carro);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Deleta um carro pelo ID")
    public void deletaCarro(@PathVariable(value="id") long id) {
        carroRepository.deleteById(id);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation(value="Atualiza carro pelo ID")
    public Carro atualizaCarro(@PathVariable(value="id") long id,
                               @RequestBody Carro carro) {
        if (listaCarroPorId(id).getId() == carro.getId()) {
            return carroRepository.save(carro);
        } else
            return listaCarroPorId(id);
    }

    @PatchMapping("/edit/{id}")
    @ApiOperation(value="Atualiza apenas um atributo de um carro")
    public Carro patchCarro(@PathVariable(value="id") long id,
                               @RequestBody Carro carro) {
        if (listaCarroPorId(id).getId() == carro.getId()) {
            return carroRepository.save(carro);
        } else
            return listaCarroPorId(id);
    }



}
