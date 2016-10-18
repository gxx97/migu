package com.gus.comms.file;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateExcel {
	public static void main(String args[]) {
		String fname = "c:/test.xls";
		try {
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File(fname));
			// 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet(" 第一页 ", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
			// 以及单元格内容为test
			Label label = new Label(0, 0, "test1");

			// 将定义好的单元格添加到工作表中
			sheet.addCell(label);

			/**
			 * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
			 */
			sheet.addCell(new jxl.write.Number(1, 0, 9990));

			sheet.addCell(new Label(0, 1, "test2"));

			sheet.addCell(new jxl.write.Number(1, 1, 5558));

			// 写入数据并关闭文件
			book.write();
			book.close();

			readE(fname);
			
			modify(fname);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//读取
	public static void readE(String fname) {
		try {
			Workbook book = Workbook.getWorkbook(new File(fname));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			System.out.println(sheet.getRows() + "--" + sheet.getColumns());
			Cell cell1 = sheet.getCell(0, 0);
			String result = cell1.getContents();
			System.out.println(result);
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//修改
	public static void modify(String fname) {
		try {
			// Excel获得文件
			Workbook wb = Workbook.getWorkbook(new File(fname));
			// 打开一个文件的副本，并且指定数据写回到原文件
			WritableWorkbook book = Workbook.createWorkbook(new File(fname), wb);
			// 添加一个工作表
//			WritableSheet sheet = book.createSheet(" 第二页 ", 1);
//			sheet.addCell(new Label(0, 0, " 第二页的测试数据 "));
			
			WritableSheet sheet = book.getSheet(0);
			
			sheet.addCell(new Label(0, 2, "新增的数据"));
			
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}