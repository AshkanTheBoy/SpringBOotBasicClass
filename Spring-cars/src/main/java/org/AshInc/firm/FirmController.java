package org.AshInc.firm;

import org.AshInc.model.ModelCar;
import org.AshInc.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class FirmController {

    @Autowired
    private  FirmService firmService;

    @Autowired
    private ModelService modelService;

    @GetMapping({"/index","/"})
    public String index(Model model) {
        model.addAttribute("firms", firmService.findAll());
        model.addAttribute("model", new ModelCar()); //Иначе будет ошибка при первом рендеринге
        return "index";
    }

    @GetMapping("/models")
    public ModelAndView models(Model model, @RequestParam(name = "id") String id) {
        //System.out.println(id);
        model.addAttribute("firms", firmService.findAll());
        Set<ModelCar> models = firmService.findModels(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView("index::models");
        modelAndView.addObject("models", models);
        return modelAndView;
    }

    @GetMapping("/model")
    public ModelAndView model(Model model, @RequestParam (name = "id") String id) {
        model.addAttribute("model", modelService.findById(Long.parseLong(id)));
        ModelAndView modelAndView = new ModelAndView("index::model");
        modelAndView.addObject("model", modelService.findById(Long.parseLong(id)));
        //System.out.println(modelService.findById(Long.parseLong(id)));
        return modelAndView;
    }
} 