package com.SmartCM.SmartCm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    // Unique ID for the user, generated automatically
    @NotBlank(message = "user name is required")
    @Size(min = 3, message = "Min 3 characters required")
    private String name;
    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Min 8 characters required")
    private String password;
    @NotBlank(message = "About is required")
    private String about;
    @Size(min = 8, max = 12, message = "Invalid phone number")
    private String phoneNumber;

    public Object getUserId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserId'");
    }

}
