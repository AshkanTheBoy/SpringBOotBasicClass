package org.AshInc.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/tables")
    public List<TableRest> getTables(){
        var tables = (List<TableRest>) tableService.findAll();
        return tables;
    }

    @GetMapping("/tables/{id}")
    public ResponseEntity<TableRest> getTable(@PathVariable Long id){
        Optional<TableRest> product = Optional.ofNullable(tableService.findById(id));
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tables")
    public ResponseEntity<TableRest> createTable(@RequestBody TableRest tableRest) {
        TableRest table = tableService.save(tableRest);
        return ResponseEntity.status(HttpStatus.CREATED).body(table);
    }

    @PutMapping("/tables/{id}")
    public ResponseEntity<TableRest> updateTable(@PathVariable Long id, @RequestBody TableRest tableRest) {
        if (!tableService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tableRest.setId(id);
        TableRest updatedTable = tableService.save(tableRest);
        return ResponseEntity.ok(updatedTable);
    }

    @DeleteMapping("/tables/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        if (!tableService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tableService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
} 