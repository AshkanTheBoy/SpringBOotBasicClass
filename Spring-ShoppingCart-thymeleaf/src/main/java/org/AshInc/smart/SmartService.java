package org.AshInc.smart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartService {
    @Autowired SmartRepo smartRepository;

    public List<Smart> findAll() {
        return smartRepository.findAll(); //список всех смартфонов
    }

    public Smart save(Smart smart) {
        return smartRepository.save(smart);
    }

    public Smart findById(Long id) {
        return smartRepository.findById(id).get()==null? smartRepository.findById(id).get():null;
    }

    public void deleteById(Long id) {
        smartRepository.deleteById(id);
    }
} 