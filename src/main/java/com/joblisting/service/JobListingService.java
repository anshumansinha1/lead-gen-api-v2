package com.joblisting.service;

import com.joblisting.controller.ProcessingOutput;
import com.joblisting.entities.JobListing;
import com.joblisting.repository.JobListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobListingService {

    @Autowired
    private JobListingRepository jobListingRepository;

    public Page<JobListing> getJobListing(Pageable pageable) {
        return jobListingRepository.findAll(pageable);
    }

    public JobListing addJobListing(JobListing jobListing) {
        return jobListingRepository.save(jobListing);
    }

    public JobListing updateProcessingData(ProcessingOutput processingOutput) {
        try {
            Optional<JobListing> oneJobListing = jobListingRepository.findById(processingOutput.getJobId());
            oneJobListing.get().setProcessed(true);
            oneJobListing.get().setRelevant(processingOutput.isRelevant());
            oneJobListing.get().setComments(processingOutput.getComment());
            JobListing save = jobListingRepository.save(oneJobListing.get());
            return save;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Illegal Argument Exception");
            return null;
        }
    }
}
