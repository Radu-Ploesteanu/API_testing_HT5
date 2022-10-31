package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(value = {"category", "photoUrls", "tags"})
public class Pet {
    private Long id;
    private String name;
    private String status;
}
