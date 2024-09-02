package org.AshInc.firm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FirmRestController {
    @Autowired
    private FirmService firmService;

    @GetMapping(value = "/firms")
    public List<Firm> firms(){
        return firmService.findAll();
    }

} 