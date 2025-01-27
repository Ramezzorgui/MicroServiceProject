package com.example.msapplication.Controller;

import com.example.msapplication.Services.JobService;
import com.example.msapplication.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")

public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/afficher")
    public List<Job> afficherTousLesJobs() {
        return jobService.getTousLesJobs();
    }

    @GetMapping("/afficher/{id}")
    public Optional<Job> afficherJobParId(@PathVariable int id) {
        return jobService.getJobParId(id);
    }



    @PutMapping("/modifier-etat/{id}")
    public Job modifierEtat(@PathVariable int id, @RequestParam boolean etat) {
        return jobService.modifierEtatJob(id, etat);
    }
}
