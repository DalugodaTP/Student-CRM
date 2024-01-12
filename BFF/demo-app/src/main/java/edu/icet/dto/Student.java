package edu.icet.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String contactNumber;
}
