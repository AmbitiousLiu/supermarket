package com.example.supermarket.sry.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Deal_Commodity {
		String cnum;
		String name;
		String sort;
		Date p_date;
		Date safe_date;
		Integer price;
		Integer sale_count;
}
