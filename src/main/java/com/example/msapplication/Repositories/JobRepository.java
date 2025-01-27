package com.example.msapplication.Repositories;

import com.example.msapplication.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job, Integer> {

}
