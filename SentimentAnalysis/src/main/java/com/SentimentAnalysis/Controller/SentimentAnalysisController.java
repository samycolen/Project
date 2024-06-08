package com.SentimentAnalysis.Controller;

import com.SentimentAnalysis.Services.SentimentAnalysisServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SentimentAnalysisController {
    @GetMapping("/")
    public String index(){
        return "inputText";
    }
    @PostMapping("/analyzeSentiment")
    public String SentimentAnalyzer(@RequestParam String inputText,Model model){
       String sentiment = SentimentAnalysisServices.analyzeSentiment(inputText);
        model.addAttribute("sentiment", sentiment);
        return "index";
    }
}
