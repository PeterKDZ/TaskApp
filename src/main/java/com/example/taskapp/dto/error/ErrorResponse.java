package com.example.taskapp.dto.error;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * The class represents an error response date transfer object.
 *
 */

@Data
@Builder
public class ErrorResponse {
    private Date timestamp;
    private String status;
    private String message;
    private String type;
}
