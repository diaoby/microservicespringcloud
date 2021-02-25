package com.huaxin.microserviceconsumer.movie.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 8912111288470833198L;
	private Long id;
	private String username;
	private String name;
	private Integer age;
	private BigDecimal balance;

}
