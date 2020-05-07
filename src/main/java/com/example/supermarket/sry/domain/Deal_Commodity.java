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
		Integer stock_count;
		Integer shelf_count;
		Integer price_in;
		Integer price_out;
}
