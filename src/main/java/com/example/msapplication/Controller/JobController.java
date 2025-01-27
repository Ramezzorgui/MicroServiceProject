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

    // Afficher tous les jobs
    @GetMapping("/afficher")
    public List<Job> afficherTousLesJobs() {
        return jobService.getTousLesJobs();
    }

    // Afficher un job par ID
    @GetMapping("/afficher/{id}")
    public Optional<Job> afficherJobParId(@PathVariable int id) {
        return jobService.getJobParId(id);
    }

    // Afficher un job par nom
    @GetMapping("/afficher/service/{service}")
    public Optional<Job> afficherJobParNom(@PathVariable String service) {
        return jobService.getJobParNom(service);
    }

    // Modifier l'état d'un job
    @PutMapping("/modifier-etat/{id}")
    public Job modifierEtat(@PathVariable int id, @RequestParam boolean etat) {
        return jobService.modifierEtatJob(id, etat);
    }
}
