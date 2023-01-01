
package com.rs.baseproject.custom.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmptyFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer employeeId;
}
