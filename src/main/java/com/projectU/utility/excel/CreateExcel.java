package com.projectU.utility.excel;

import java.io.FileOutputStream;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 
 * @author sanjeet.pandit
 *
 */
@SuppressWarnings("resource")
public class CreateExcel {

	private static Logger logger = Logger.getLogger(CreateExcel.class);

	/**
	 * @author dhiraj.bendale
	 * @param filePath
	 */
	public void createBlankHSSF(String filePath) {
		logger.info("Creating blank HSSF " + filePath);
		try {
			Workbook wb = new HSSFWorkbook();
			FileOutputStream fileOut = new FileOutputStream(filePath);
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			logger.error("Exception..!", e);
		}
		logger.info("Blank HSSF created successfully. " + filePath);
	}
}
