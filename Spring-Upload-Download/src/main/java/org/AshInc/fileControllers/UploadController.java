package org.AshInc.fileControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @PostMapping()
    public RedirectView uploadAll(@RequestParam("file")MultipartFile[] files, RedirectAttributes redirectAttributes){
        for (MultipartFile file: files){
            String fileName = file.getOriginalFilename();
            redirectAttributes.addFlashAttribute("message","Successful uploading of "+fileName);
            System.out.println(fileName);
            File uploadedDirectory = new File("C:\\Users\\gk\\Documents\\SpringbootBasic\\Spring-Upload-Download\\src\\main\\resources\\files");
            System.out.println(uploadedDirectory);
            try {
                file.transferTo(new File(uploadedDirectory+"\\"+fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new RedirectView("index");
    }
}
