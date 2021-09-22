package springframework.jokesapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.jokesapp.Services.JokeService;

@Controller
public class JokeController {
    private final JokeService jokeService;

    //@Autowired is omitted because we have only one constructor and spring will automatically inject into this
    //spring 4.2 provided that functionality
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;

    }
    @RequestMapping({"/listentojoke",""})
    public String showJoke(Model model) {
        model.addAttribute("joke",jokeService.getJoke());
        return "index";
    }
}
