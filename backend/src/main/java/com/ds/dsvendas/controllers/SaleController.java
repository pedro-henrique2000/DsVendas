package com.ds.dsvendas.controllers;

import com.ds.dsvendas.dto.SaleDTO;
import com.ds.dsvendas.repositories.SellerRepository;
import com.ds.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> page = saleService.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}
