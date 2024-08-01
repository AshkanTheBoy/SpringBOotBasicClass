package org.AshInc.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public List<TableRest> findAll() {
        return (List<TableRest>) tableRepository.findAll();
    }

    public TableRest findById(Long id) {
        return tableRepository.findById(id).orElse(null);
    }

    public TableRest save(TableRest tableRest){
        return tableRepository.save(tableRest);
    }

    public void deleteById(Long id){
        tableRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return tableRepository.existsById(id);
    }
} 