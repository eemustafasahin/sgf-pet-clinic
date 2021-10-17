package guru.springframework.sgfpetclinic.controller;

import guru.springframework.sgfpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService m_ownerService;

    public OwnerController(OwnerService ownerService)
    {
        m_ownerService = ownerService;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String listOwners(Model model)
    {
        model.addAttribute("owners", m_ownerService.findAll());

        return "owners/index";
    }
}
