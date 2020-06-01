package com.example.supermarket.sry.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Deal_Commodity {
		String cnum;
		String name;
		String region;
		Date p_date;
		String safe_date;
		Integer count;
		Integer price_out;
}
