package springframework.petclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springframework.petclinic.Model.Owner;
import springframework.petclinic.services.OwnerService;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }
    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder());
        return "owners/findOwners";
    }
    @GetMapping
    public String processFindForm(Owner owner, BindingResult bindingResult,Model model){
        if(owner.getLastName()==null){
            owner.setLastName("");//empty string signifies broadest possible search
        }
        List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());
        if(results.isEmpty()){
            bindingResult.rejectValue("lastName","not found","not found");
            return "owners/findOwners";
        }
        else if(results.size()==1){
            owner = results.get(0);
            return "redirect:/owners/" +owner.getId();
        }
        else {
            model.addAttribute("selections",results);
            return "owners/ownersList";
        }
    }
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId){
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }
}
