package com.endur.miniproj;

import com.opencsv.bean.CsvBindByPosition;

public class SimplePositionBean  {
	    @CsvBindByPosition(position = 0)
	    private String exampleColOne;

	    @CsvBindByPosition(position = 1)
	    private String exampleColTwo;

	    // getters and setters
	}
