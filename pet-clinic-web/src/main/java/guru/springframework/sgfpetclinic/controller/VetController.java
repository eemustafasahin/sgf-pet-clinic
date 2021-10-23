package guru.springframework.sgfpetclinic.controller;

import guru.springframework.sgfpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService m_vetService;

    public VetController(VetService vetService)
    {
        m_vetService = vetService;
    }


    @RequestMapping({"","/", "/index","index.html"})
    public String listVets(Model model)
    {
        model.addAttribute("vets",m_vetService.findAll());

        return "vets/index";
    }
}
