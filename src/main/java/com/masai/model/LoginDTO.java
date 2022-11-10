package com.masai.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginDTO {
	private String mobileNo;
	private String password;
}
