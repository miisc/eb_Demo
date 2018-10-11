package com.demo.exam.util;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

public class ImportUtil {

	private static final Logger log = LoggerFactory.getLogger(ImportUtil.class);

	public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
		if (StringUtils.isBlank(filePath)) {
			return null;
		}
		ImportParams params = new ImportParams();
		params.setTitleRows(titleRows);
		params.setHeadRows(headerRows);
		List<T> list = null;
		try {
			list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
		} catch (NoSuchElementException e) {
			log.error("模板不能为空");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return list;
	}

}
