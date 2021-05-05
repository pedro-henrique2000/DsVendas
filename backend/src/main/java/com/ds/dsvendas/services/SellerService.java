package com.ds.dsvendas.services;

import com.ds.dsvendas.dto.SellerDTO;
import com.ds.dsvendas.entities.Seller;
import com.ds.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerDTO> findAll() {
        List<Seller> result = sellerRepository.findAll();

        return result.stream().map(SellerDTO::new).collect(Collectors.toList());
    }

}
