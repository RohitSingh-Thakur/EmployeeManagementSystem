
package com.rs.baseproject.custom.exception;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
public class NoRecordFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
