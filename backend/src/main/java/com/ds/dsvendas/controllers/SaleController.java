package com.ds.dsvendas.controllers;

import com.ds.dsvendas.dto.SaleSuccessDTO;
import com.ds.dsvendas.dto.SaleDTO;
import com.ds.dsvendas.dto.SaleSumDTO;
import com.ds.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> list = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> percentage() {
        List<SaleSuccessDTO> list = saleService.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }
}
