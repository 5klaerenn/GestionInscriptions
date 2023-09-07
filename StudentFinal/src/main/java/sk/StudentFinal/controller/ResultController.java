package sk.StudentFinal.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.StudentFinal.Service.ResultServiceImpl;
import sk.StudentFinal.model.Result;

import java.util.List;

@Controller
@RequestMapping("/app")
public class ResultController {

    private ResultServiceImpl resultService;
    public ResultController(ResultServiceImpl resultService){this.resultService = resultService;}

    private List<Result> resultList;

    @PostConstruct
    public void loadData(){
        resultList = resultService.findAll();
    }

    @GetMapping("/results")
    public String afficherTout(Model model){
        model.addAttribute("results", resultList);
        return "list-results";
    }

}
