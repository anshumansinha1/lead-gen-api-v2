package com.joblisting.entities;

import com.sun.org.apache.xerces.internal.xs.StringList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sourceJobId = "";
    @NonNull
    private String source;
    @NonNull
    private String jobUrl;
    private String workExperience = "";
    @NonNull
    private String role;
    @NonNull
    private String companyName;
    @NonNull
    private String description;
    @NonNull
    private String location;
    private String skills = "";
    private boolean processed = false;
    private boolean relevant = false;
    private String comments = "";
}