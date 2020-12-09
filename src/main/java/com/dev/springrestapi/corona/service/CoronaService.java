package com.dev.springrestapi.corona.service;

import com.dev.springrestapi.corona.domain.Corona;
import com.dev.springrestapi.corona.repository.CoronaRepository;
import com.dev.springrestapi.corona.repository.querydsl.interfaces.CoronaQueryDSLInterface;
import com.dev.springrestapi.corona.service.interfaces.CoronaServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service("CoronaService")
public class CoronaService implements CoronaServiceInterface, CoronaQueryDSLInterface {
    private CoronaRepository coronaRepository;

    public List<Corona> getFindAll(){
        return coronaRepository.findAll();
    }

    @Override
    public List<Corona> getCoronaByCountryName(String beginDate, String endDate, String countryName) {
        return coronaRepository.getCoronaByCountryName(beginDate, endDate, countryName);
    }
}
