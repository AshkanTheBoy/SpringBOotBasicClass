package org.AshInc.smart;

import org.AshInc.firm.FirmService;
import org.AshInc.os.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SmartController {
    @Autowired
    SmartService smartService;
    @Autowired
    FirmService firmService;
    @Autowired
    OsService osService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/smarts")
    public String firms(Model model) {
        model.addAttribute("smarts", smartService.findAll());
        return "smarts";
    }

    @GetMapping(value = "/smart_add")
    public String smartAdd(Model model) {
        model.addAttribute("smart", new Smart());
        model.addAttribute("firms", firmService.findAll());
        model.addAttribute("oss", osService.findAll());
        return "smart_add";
    }

    @PostMapping(value = "/smart_add")
    public String smartSave(Smart smart, Model model, HttpServletResponse response) {
        if (smart.getFirm()==null || smart.getOs()==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The firm or the OS is null");
        Smart newSmart = smartService.save(smart);
        long id = newSmart.getId();
        response.addHeader("id", String.valueOf(id));
        model.addAttribute("smarts", smartService.findAll());
        return "redirect:/smarts";
    }

    @DeleteMapping(value ="/smart_delete")
    public String deleteSmartphone(@RequestParam(name="id")Long id) {
        smartService.deleteById(id);
        return "redirect:/smarts";
    }


    @GetMapping(value ="/smart_update")
    public String editSmart(Model model, @RequestParam(name="id")Long id) {
        Smart smartphone = smartService.findById(id);
        model.addAttribute("smart",smartphone);
        model.addAttribute("os",osService.findAll());
        model.addAttribute("firms",firmService.findAll());
        return "smart_update";
    }

    @PutMapping(value="/smart_update")
    public String updateSmart(Smart smartphone, Model model) {
        Smart smartphoneDb = smartService.findById(smartphone.getId());
        //System.out.println(smartphone.getFirm());
        // System.out.println(smartphoneDb.getFirm());
        smartphoneDb.setName(smartphone.getName());
        smartphoneDb.setFirm(smartphone.getFirm());
        smartphoneDb.setOs(smartphone.getOs());
        smartphoneDb.setSize(smartphone.getSize());
        smartphoneDb.setColor(smartphone.getColor());
        smartService.save(smartphoneDb);
        model.addAttribute("smarts", osService.findAll());
        return "redirect:/smarts";
    }
} 