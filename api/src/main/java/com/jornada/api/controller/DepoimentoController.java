package com.jornada.api.controller;

import com.jornada.api.dto.DepoimentoDTO;
import com.jornada.api.entity.Depoimento;
import com.jornada.api.service.DepoimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/depoimentos")
public class DepoimentoController {

    @Autowired
    private DepoimentoService service;

    @GetMapping
    public List<DepoimentoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public DepoimentoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DepoimentoDTO save(@RequestBody Depoimento depoimento) {
        return service.save(depoimento);
    }

//    @DeleteMapping
//    @RequestMapping(value = "/{id}")
//    public void deleteById() {
//
//    }
}
