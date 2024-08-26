package AshInc.firm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FirmController {
    @Autowired
    FirmService firmService;


    @GetMapping(value = "/firms")
    public String firms(Model model) {
        model.addAttribute("firms", firmService.findAll());
        return "firms";
    }


    @GetMapping(value = "/firm_add")
    public String firmAdd(Model model) {
        model.addAttribute("firm", new Firm());
        return "firm_add";
    }

    @PostMapping(value = "/firm_add")
    public String firmSave(Firm firm, Model model, HttpServletResponse response) {
        Firm newFirm = firmService.save(firm);
        long id = newFirm.getId();
        response.addHeader("id", String.valueOf(id));
        model.addAttribute("firms", firmService.findAll());
        return "redirect:/firms";
    }

    @DeleteMapping(value = "/firm_delete")
    public String firmDelete(@RequestParam(name="id")Long id){
        firmService.deleteById(id);
        return "redirect:/firms";
    }

    @GetMapping(value="/firm_update")
    public String firmGetUpdate(Model model, @RequestParam(name="id")  Long id){
        Firm oldFirm = firmService.findById(id);
        model.addAttribute("firm", oldFirm);
        return "firm_update";
    }

    @PutMapping(value = "/firm_update")
    public String firmUpdate(Firm firm, Model model){
     Firm oldFirm=firmService.findById(firm.getId());
     oldFirm.setName(firm.getName());
     firmService.save(oldFirm);
     model.addAttribute("firms",firmService.findAll());
     return "redirect:/firms";
    }
} 