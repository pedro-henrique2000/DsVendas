package com.ds.dsvendas.services;

import com.ds.dsvendas.dto.SaleDTO;
import com.ds.dsvendas.entities.Sale;
import com.ds.dsvendas.repositories.SaleRepository;
import com.ds.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> page = saleRepository.findAll(pageable);
        return page.map(SaleDTO::new);
    }
}
