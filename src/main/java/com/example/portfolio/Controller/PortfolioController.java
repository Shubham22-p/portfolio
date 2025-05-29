package com.example.portfolio.Controller;

import com.example.portfolio.model.ContactMessage;
import com.example.portfolio.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@CrossOrigin(origins = "*")  // Adjust for production
public class PortfolioController {

    @Autowired
    private ContactMessageRepository repository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/resume")
    public String resume() {
        return "resume";
    }

    @GetMapping("/contact")
    public String contactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitMessage(@ModelAttribute ContactMessage message) {
        repository.save(message);
        return "redirect:/contact?success";
    }
    @PostMapping
    public ResponseEntity<String> saveMessage(@RequestBody ContactMessage message) {
        repository.save(message);
        return ResponseEntity.ok("Message received!");
    }
}