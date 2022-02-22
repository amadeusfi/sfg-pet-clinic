package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    // means when the request comes in to the root context, / , index or index.html they are all going to match to this Request Mapping

    @RequestMapping({"","/","index","index.html"})
    public String index(){
        return "index";
    }
}
