package com.rcm.addressapi.service;

import com.rcm.addressapi.rest.dto.ViaCepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "viacep-client", url = "http://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    ViaCepDto getAddress(@RequestParam String cep);
}
