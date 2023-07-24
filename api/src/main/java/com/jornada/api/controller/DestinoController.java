package com.jornada.api.controller;

import com.jornada.api.dto.depoimentos.DadosAtualizacaoDepoimento;
import com.jornada.api.dto.depoimentos.DadosDetalhamentoDepoimento;
import com.jornada.api.dto.destinos.*;
import com.jornada.api.entity.Depoimento;
import com.jornada.api.entity.Destino;
import com.jornada.api.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/destinos")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public ResponseEntity<List<DadosListagemDestino>> findAll() {
        var destinos = this.destinoService.findAll();
        return ResponseEntity.ok(destinos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody DadosCadastroDestino dados, UriComponentsBuilder uriBuilder) {
        var destino = new Destino(dados);
        this.destinoService.save(destino);
        var uri = uriBuilder.path("/destinos/{id}").buildAndExpand(destino.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemDestinoCompleto(destino));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        this.destinoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody DadosAtualizacaoDestino dados) {
        this.destinoService.update(dados);
        return ResponseEntity.ok(new DadosDetalhamentoDestino(dados));
    }

}
