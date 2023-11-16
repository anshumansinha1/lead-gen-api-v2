package com.joblisting.controller;

import com.joblisting.entities.JobListing;
import com.joblisting.entities.Product;
import com.joblisting.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job-listing")
public class JobListingController {

    @Autowired
    private JobListingService jobListingService;

    @PutMapping
    public JobListing updateJobListing(@RequestBody ProcessingOutput processingOutput) {
        return jobListingService.updateProcessingData(processingOutput);
    }

    @PostMapping
    public JobListing addJobListing(@RequestBody JobListing jobListing) {
        return jobListingService.addJobListing(jobListing);
    }

    @GetMapping
    public Page<JobListing> getJobListing(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            //@RequestParam(name = "sort", defaultValue = "id,asc") String[] sort
            @RequestParam(name = "sortField", defaultValue = "location") String sortField,
            @RequestParam(name = "sortOrder", defaultValue = "asc") String sortOrder) {
        Sort.Order order = Sort.Order.by(sortField).with(Sort.Direction.fromString(sortOrder));
        Pageable pageable = PageRequest.of(page, size, Sort.by(order));
        return jobListingService.getJobListing(pageable);
    }
}
