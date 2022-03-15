package com.elj.gestioncinema.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@AllArgsConstructor @NoArgsConstructor @Data @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorMessage {
    String message;
    Date timestamp;
    Integer code;
}
