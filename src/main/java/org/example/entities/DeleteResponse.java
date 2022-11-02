package org.example.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeleteResponse {
    private Integer code;
    private String type;
    private String message;
}
