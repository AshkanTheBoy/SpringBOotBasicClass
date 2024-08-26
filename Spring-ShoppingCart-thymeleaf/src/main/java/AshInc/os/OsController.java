package AshInc.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
    public class OsController {

        @Autowired
        private OsService osService;

        @GetMapping(value ="/os_add")
        public String indexOs(Model model) {
            model.addAttribute("os",new Os()); //Если не добавить, то не будет выполняться парсинг шаблона исходной страницы
            return "os_add";
        }

        @GetMapping(value ="/oss" )
        public String listOs(Model model) {
            model.addAttribute("oss", osService.findAll());
            return "oss";
        }

        @PostMapping(value="/os_add")
        public String saveOs(Os os, Model model, HttpServletResponse response) {
            //Передать id в заголовке ответа
            Os newOs = osService.save(os);
            long id = newOs.getId();
            response.addHeader("id", String.valueOf(id));
            model.addAttribute("os", osService.findAll());
            return "redirect:/oss";
        }

    @DeleteMapping(value = "/os_delete")
        public String deleteOs(@RequestParam(name="id")Long id) { osService.deleteById(id);
        return "redirect:/oss";
        }

    @GetMapping(value ="/os_edit")
    public String editOs(Model model, @RequestParam(name="id")Long id) {
            Os os = osService.findById(id);
        model.addAttribute("os",os);
        return "os_edit";
    }

    @PutMapping(value="/os_update")
    public String updateOs(Os os, Model model) {
            Os osDb = osService.findById(os.getId());
        osDb.setName(os.getName());
        osDb.setDeveloper(os.getDeveloper());
        //osService.deleteById(os.getId());
        osService.save(osDb);
        model.addAttribute("os", osService.findAll());
        return "redirect:/oss";
    }
    } 