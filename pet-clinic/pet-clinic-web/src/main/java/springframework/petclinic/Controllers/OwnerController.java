package springframework.petclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.petclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
     OwnerService ownerService;



    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }
    @RequestMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }
}
