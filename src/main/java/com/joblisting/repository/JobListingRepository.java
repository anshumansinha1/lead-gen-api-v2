package com.joblisting.repository;

import com.joblisting.entities.JobListing;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobListingRepository extends PagingAndSortingRepository<JobListing, Long> {
}
