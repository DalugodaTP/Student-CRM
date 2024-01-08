package edu.icet.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private String contactNumber;
}
