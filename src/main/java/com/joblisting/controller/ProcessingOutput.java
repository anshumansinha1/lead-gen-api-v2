package com.joblisting.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessingOutput {
    @NonNull
    private Long jobId;
    private boolean relevant;
    private String comment = "";
    @NonNull
    private String trackName;
}
