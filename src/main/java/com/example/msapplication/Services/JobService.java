package com.example.msapplication.Services;

import com.example.msapplication.Repositories.JobRepository;
import com.example.msapplication.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getTousLesJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobParId(int id) {
        return jobRepository.findById(id);
    }

    public Optional<Job> getJobParNom(String service) {
        return jobRepository.findByService(service);
    }

    public Job modifierEtatJob(int id, boolean etat) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job non trouvé"));
        job.setEtat(etat);
        return jobRepository.save(job);
    }
}
