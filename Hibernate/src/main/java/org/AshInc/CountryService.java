package org.AshInc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;

    public List<Country> findAll(){
        return countryRepo.findAll();
    }

    public Country findById(Long id){
        return countryRepo.findById(id).orElse(null);
    }

    public List<Country> findAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return countryRepo.findAll(pageable).getContent();
    }

    public List<Country> saveAll(List<Country> countries){
        return countryRepo.saveAll(countries);
    }

    public Long countryCount(){
        return countryRepo.count();
    }
}
