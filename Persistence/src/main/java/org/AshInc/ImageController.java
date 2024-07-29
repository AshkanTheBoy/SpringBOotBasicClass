package org.AshInc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller
public class ImageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/image/{id}")
    public String showImage(Model model, @PathVariable Long id) {
        Optional<Product> product = Optional.ofNullable(productService.findById(id));
        //String base64Image = Base64.getEncoder().encodeToString(product.get().getPicture());
        String base64Image = new String(product.get().getPicture(), StandardCharsets.UTF_8);
        model.addAttribute("image", base64Image);
        return "image";
    }
} 