package org.AshInc.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tables")
public class TableThymeleafController {

    @Autowired
    private TableService tableService;

    // Отображение списка столиков
    @GetMapping
    public String getTables(Model model) {
        List<TableRest> tables = (List<TableRest>) tableService.findAll();
        model.addAttribute("tables", tables);
        return "tables";
    }

    // Отображение формы для создания нового столика
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("table", new TableRest());
        return "createTable";
    }

    // Обработка создания нового столика
    @PostMapping
    public String createTable(@ModelAttribute TableRest tableRest) {
        System.out.printf("id: %d, number: %s%n", tableRest.getId(), tableRest.getNumber());
        tableRest.setId(0L);
        tableService.save(tableRest);
        return "redirect:/tables";
    }

    // Отображение формы для редактирования столика
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        TableRest table = tableService.findById(id);
        model.addAttribute("table", table);
        return "editTable";
    }

    // Обработка обновления столика
    @PostMapping("/{id}")
    public String updateTable(@PathVariable Long id, @ModelAttribute TableRest tableRest) {
        tableRest.setId(id);
        tableService.save(tableRest);
        return "redirect:/tables";
    }

    // Обработка удаления столика
    @PostMapping("/{id}/delete")
    public String deleteTable(@PathVariable Long id) {
        tableService.deleteById(id);
        return "redirect:/tables";
    }
} 