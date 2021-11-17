package com.endur.miniproj;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class BeanCSVUtil {

	
	 public List<CSVBean> beanBuilderExample(Path path, Class clazz) throws Exception {
	     CsvTransfer csvTransfer = new CsvTransfer();
	     ColumnPositionMappingStrategy ms = new ColumnPositionMappingStrategy();
	     ms.setType(clazz);

	     Reader reader = Files.newBufferedReader(path);
	     CsvToBean cb = new CsvToBeanBuilder(reader)
	       .withType(clazz)
	       .withMappingStrategy(ms)
	       .build();

	    csvTransfer.setCsvList(cb.parse());
	    reader.close();
	    return csvTransfer.getCsvList();
	}
	
	 
	 public String simplePositionBeanExample() throws Exception {
		    Path path = Paths.get(
		      ClassLoader.getSystemResource("csv/twoColumn.csv").toURI()); 
		    return beanBuilderExample(path, SimplePositionBean.class).toString(); 
		}
	
}
