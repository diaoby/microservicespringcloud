package com.huaxin.micorserviceprovider.user.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 226695758444267342L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	@Column
	private String username;
	@Column
	private String name;
	@Column
	private Integer age;
	@Column
	private BigDecimal balance;
	
	
}
