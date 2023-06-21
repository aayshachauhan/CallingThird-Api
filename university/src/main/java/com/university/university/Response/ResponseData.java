package com.university.university.Response;


import com.university.university.Entity.College;
import com.university.university.Entity.StudentEntity;

import lombok.Data;

@Data
public class ResponseData {

	private StudentEntity student;
	private College college;
}
