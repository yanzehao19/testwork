package poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.record.cf.FontFormatting;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.ibm.icu.util.Calendar;

public class POIoperationExcel {

	// 创建Workbook和Sheet
	@SuppressWarnings({ "resource", "unused" })
	public void createWorkbookAndSheet() throws IOException {
		String filePath = "d:\\sampl.xls";// 文件路径
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（sheet）
		sheet = workbook.createSheet("Test");// 创建工作表（sheet）
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);// 保存Excel文件
		out.close();// 关闭文件流
		System.out.println("OK");
	}

	// 创建单元格
	@SuppressWarnings("resource")
	public void createRowAndCell() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（sheet）
		HSSFRow row = sheet.createRow(0);// 创建行，从0开始
		HSSFCell cell = row.createCell(0);// 创建行的单元格，也是从0开始
		cell.setCellValue("women");// 设置单元格内容
		row.createCell(1).setCellValue(false);// 设置单元内容，重载
		row.createCell(2).setCellValue(new Date());// 设置单元内容，重载
		row.createCell(3).setCellValue(12.345);// 设置单元内容，重载
	}

	// 创建文档摘要信息
	public void createExcelInformation() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		workbook.createInformationProperties();// 创建文档信息
		DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();// 摘要信息
		dsi.setCategory("类别");// 类别
		dsi.setManager("管理");// 管理者
		dsi.setCompany("公司");// 公司
		SummaryInformation si = workbook.getSummaryInformation();// 摘要信息
		si.setSubject("主题");// 主题
		si.setTitle("标题");// 标题
		si.setAuthor("作者");// 作者
		si.setComments("备注");// 备注
	}

	// 创建批注
	public void createComment() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（sheet）
		HSSFPatriarch patr = sheet.createDrawingPatriarch();
		HSSFClientAnchor anchor = patr.createAnchor(0, 0, 0, 0, 5, 1, 8, 3);// 创建批注位置
		HSSFComment comment = patr.createCellComment(anchor);// 创建批注
		comment.setString(new HSSFRichTextString("批注段落"));// 设置批注内容
		comment.setAuthor("womne");// 设置批注作者
		comment.setVisible(true);// 设置批注默认显示
		HSSFCell cell = sheet.createRow(2).createCell(1);
		cell.setCellValue("测试");
		cell.setCellComment(comment);// 把批注赋值给单元格
	}

	// 创建页眉和页脚
	public void createHeaderAndFooter() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（sheet）
		HSSFHeader header = sheet.getHeader();// 得到页眉
		header.setLeft("页眉左边");
		header.setRight("页眉右边");
		header.setCenter("页眉中间");
		HSSFFooter footer = sheet.getFooter();// 得到页脚
		footer.setLeft("页脚左边");
		footer.setRight("页脚右边");
		footer.setCenter("页脚中间");
	}

	// Excel单元格操作

	// 1设置格式
	public void setStyle() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（sheet）
		HSSFRow row = sheet.createRow(0);
		// 设置日期格式--使用Excel内嵌的格式
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(new Date());
		HSSFCellStyle style = workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		cell.setCellStyle(style);

		// 设置保留2位小数--使用Excel内嵌的格式
		cell = row.createCell(1);
		cell.setCellValue(12.3245679);
		style = workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		cell.setCellStyle(style);
		// 设置货币格式--使用自定义的格式
		cell = row.createCell(2);
		cell.setCellValue(12345.6789);
		style = workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("￥#，##0"));
		cell.setCellStyle(style);
		// 设置百分比格式--使用自定义的格式
		cell = row.createCell(3);
		cell.setCellValue(0.123456789);
		style = workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));
		cell.setCellStyle(style);

		// 设置中文大写格式--使用自定义的格式
		cell = row.createCell(4);
		cell.setCellValue(12345);
		style = workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("[DbNum2][$-804]0"));
		cell.setCellStyle(style);

		// 设置科学计数法格式--使用自定义的格式
		cell = row.createCell(5);
		cell.setCellValue(12345);
		style = workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("0.00e+00"));
		cell.setCellStyle(style);

	}

	// 2合并单元格
	public void mergeCell() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		// 合并列
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("合并列");
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 5);
		sheet.addMergedRegion(region);
		// 合并行
		cell = row.createCell(6);
		cell.setCellValue("合并行");
		region = new CellRangeAddress(0, 5, 6, 6);
		sheet.addMergedRegion(region);
	}

	// 3单元格对齐
	public void cellAlign() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("单元格对齐");
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		style.setWrapText(true);// 自动换行
		style.setIndention((short) 5);// 缩进
		style.setRotation((short) 60);// 文本旋转，这里的取值是从-90到90而不是0-180度。
		cell.setCellStyle(style);
	}

	// 4使用边框
	public void useBorder() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue("设置边框");
		HSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);// 上边框
		style.setBorderBottom(HSSFCellStyle.BORDER_THICK);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);// 右边框
		style.setTopBorderColor(HSSFColor.RED.index);// 上边框颜色
		style.setBottomBorderColor(HSSFColor.BLUE.index);// 下边框颜色
		style.setLeftBorderColor(HSSFColor.GREEN.index);// 左边框颜色
		style.setRightBorderColor(HSSFColor.PINK.index);// 右边框颜色
		cell.setCellStyle(style);
	}

	// 5设置字体
	public void setFont() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue("设置字体");
		HSSFCellStyle style = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setFontName("华文行楷");// 设置字体名称
		font.setFontHeightInPoints((short) 28);// 设置字号
		font.setColor(HSSFColor.RED.index);// 设置字体颜色
		font.setUnderline(FontFormatting.U_SINGLE);// 设置下划线
		font.setTypeOffset(FontFormatting.SS_SUPER);// 设置上标下标
		font.setStrikeout(true);// 设置删除线
		style.setFont(font);
		cell.setCellStyle(style);
	}

	// 6背景和纹理
	public void setBackgroundAndPattern() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(1);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREEN.index);// 设置图案颜色
		style.setFillBackgroundColor(HSSFColor.RED.index);// 设置图案背景色
		style.setFillPattern(HSSFCellStyle.SQUARES);// 设置图案样式
		cell.setCellStyle(style);
	}

	// 7设置宽度和高度
	public void setWidthAndHeight() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(1);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue("1234567890123456789");
		sheet.setColumnWidth(1, 31 * 256);// 设置第一列的宽度是31个字符宽度
		row.setHeightInPoints(50);// 设置行的高度是50个点
	}

	// 8判断单元格是否为日期
	public void cellIsDate() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(1);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue(new Date());// 设置日期数据
		System.out.println(DateUtil.isCellDateFormatted(cell));// 输出：false
		HSSFCellStyle style = workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		cell.setCellStyle(style);// 设置日期样式
		System.out.println(DateUtil.isCellDateFormatted(cell));// 输出;true
	}

	// 使用Excel公式
	// 1基本计算
	public void baseCalculate() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellFormula("2+3*4");// 设置公式
		cell = row.createCell(1);
		cell.setCellValue(10);
		cell = row.createCell(2);
		cell.setCellFormula("A1*B1");// 设置公式
	}

	// 2sum函数
	public void sumFunction() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue(1);
		row.createCell(1).setCellValue(2);
		row.createCell(2).setCellValue(3);
		row.createCell(3).setCellValue(4);
		row.createCell(4).setCellValue(5);
		row = sheet.createRow(1);
		row.createCell(0).setCellFormula("sum(A1,C1)");// 等价于“A1+C1”
		row.createCell(0).setCellFormula("sum(B1:D1)");// 等价于“B1+C1+D1”
	}

	// 3日期函数
	public void dateFunction() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFCellStyle style = workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-mm-dd"));
		HSSFRow row = sheet.createRow(0);
		Calendar date = Calendar.getInstance();// 日历对象
		HSSFCell cell = row.createCell(0);
		date.set(2011, 2, 7);
		cell.setCellValue(date.getTime());
		cell.setCellStyle(style);// 第一个单元格开始时间设置完成
		cell = row.createCell(1);
		date.set(2014, 4, 25);
		cell.setCellValue(date.getTime());
		cell.setCellStyle(style);// 第一个单元格结束时间设置完成
		cell = row.createCell(3);
		cell.setCellFormula("CONCATENATE(DATADIF(A1,B1,\"y\"),\"年\")");
		cell = row.createCell(4);
		cell.setCellFormula("CONCATENATE(DATADIF(A1,B1,\"m\"),\"月\")");
		cell = row.createCell(5);
		cell.setCellFormula("CONCATENATE(DATADIF(A1,B1,\"d\"),\"日\")");

	}

	// 4字符串相关函数
	public void stringFunction() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("abcdefg");
		row.createCell(1).setCellValue("aa bb cc dd ee ff gg");
		row.createCell(3).setCellFormula("UPPER(A1)");
		row.createCell(4).setCellFormula("PROPER(B1)");
	}

	// 5if函数
	public void ifFunction() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue(12);
		row.createCell(1).setCellValue(23);
		row.createCell(3).setCellFormula("IF(A1>B1,\"A1大于B1\",\"A1小于等于B1\")");
	}

	// 6countif函数和sumif函数
	public void countIfAndsumIf() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue(57);
		row.createCell(1).setCellValue(23);
		row.createCell(2).setCellValue(12);
		row.createCell(3).setCellValue(23);
		row.createCell(4).setCellValue(12);
		row.createCell(5).setCellValue(23);
		row.createCell(7).setCellFormula("COUNTIF(A1:F1,\">=60\")");
		row.createCell(8).setCellFormula("SUMIF(A1:F1,\">=60\",A1:F1)");
	}

	// 7Lookup函数
	public void lookupFunction() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue(0);
		row.createCell(1).setCellValue(59);
		row.createCell(2).setCellValue("不及格");
		row = sheet.createRow(1);
		row.createCell(0).setCellValue(60);
		row.createCell(1).setCellValue(69);
		row.createCell(2).setCellValue("及格");
		row = sheet.createRow(2);
		row.createCell(0).setCellValue(70);
		row.createCell(1).setCellValue(79);
		row.createCell(2).setCellValue("良好");
		row = sheet.createRow(3);
		row.createCell(0).setCellValue(80);
		row.createCell(1).setCellValue(100);
		row.createCell(2).setCellValue("优秀");
		row = sheet.createRow(3);
		row.createCell(0).setCellValue(75);
		row.createCell(1).setCellFormula("LOOKUP(A5,$A$1:$A$4,$C$1:$C$4)");
		row.createCell(2).setCellFormula("VLOOKUP(A5,$A$1:$C$4,3,true)");

	}

	// 8随机数函数
	public void randomFunction() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellFormula("RAND()");// 取0-1之间的随机数
		row.createCell(1).setCellFormula("int(RAND()*100)");// 取0-100之间的随机整数
		row.createCell(2).setCellFormula("rand()*10+10");// 取10-20之间的随机数
		row.createCell(3).setCellFormula("CHAR(INT(RAND()*26+97))");// 随机小写字母
		row.createCell(4).setCellFormula("CHAR(INT(RAND()*26+65))");// 随机大写字母
		row.createCell(5).setCellFormula("CHAR(INT(RAND()*26+if(INT(RAND()*2)=0,97,65))");// 随机大小写字母

	}

	// 9获取公式的返回值
	public void getResultOfFormula() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue(80);// A1
		row.createCell(1).setCellValue(100);// B1
		HSSFCell cell = row.createCell(2);
		cell.setCellFormula("A1*B1+14");
		HSSFFormulaEvaluator e = new HSSFFormulaEvaluator(workbook);
		cell = e.evaluateInCell(cell);// 若Excel文件不是poi创建的，则不必调用此方法
		System.out.println("公式计算结果" + cell.getNumericCellValue());
	}

	// 使用图形
	// 1画线
	public void drawLine() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 1, 0, (short) 4, 4);
		HSSFSimpleShape line = patriarch.createSimpleShape(anchor);
		line.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);// 设置图形类型
		line.setLineStyle(HSSFShape.LINESTYLE_SOLID);// 设置图形样式
		line.setLineWidth(6350);// 在poi中线的宽度12700表示1pt，所以这里是0.5pt粗的线条
	}

	// 2画矩形
	public void drawRectangle() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		HSSFClientAnchor anchor = new HSSFClientAnchor(255, 122, 255, 122, (short) 1, 0, (short) 4, 3);
		HSSFSimpleShape rec = patriarch.createSimpleShape(anchor);
		rec.setShapeType(HSSFSimpleShape.OBJECT_TYPE_RECTANGLE);// 设置图形类型
		rec.setLineStyle(HSSFShape.LINESTYLE_DASHGEL);// 设置边框样式
		rec.setFillColor(255, 0, 0);// 设置填充色
		rec.setLineWidth(25400);// 在poi中线的宽度12700表示1pt，所以这里是0.5pt粗的线条
		rec.setLineStyleColor(0, 0, 255);// 设置边框颜色
	}

	// 3画圆形
	public void drawCircle() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		HSSFClientAnchor anchor = new HSSFClientAnchor(255, 122, 255, 122, (short) 1, 0, (short) 4, 3);
		HSSFSimpleShape cir = patriarch.createSimpleShape(anchor);
		cir.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);// 设置图形类型
		cir.setLineStyle(HSSFShape.LINESTYLE_DASHGEL);// 设置边框样式
		cir.setFillColor(255, 0, 0);// 设置填充色
		cir.setLineWidth(25400);// 在poi中线的宽度12700表示1pt，所以这里是0.5pt粗的线条
		cir.setLineStyleColor(0, 0, 255);// 设置边框颜色
	}

	// 4画Grid
	public void drawGrid() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		HSSFRow row = sheet.createRow(2);
		row.createCell(1);
		row.setHeightInPoints(240);
		sheet.setColumnWidth(2, 9000);
		int linesCount = 20;
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 因为HSSFClientAnchor中dx只能再0-1023之间，dy只能再0-255之间，这里采用比例的方式
		double xRatio = 1023.0 / (linesCount * 10);
		double yRatio = 255.0 / (linesCount * 10);
		// 画竖线
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 200;
		for (int i = 0; i < linesCount; i++) {
			HSSFClientAnchor a2 = new HSSFClientAnchor();
			a2.setAnchor((short) 2, 2, (int) (x1 * xRatio), (int) (y1 * yRatio), (short) 2, 2, (int) (x2 * xRatio),
					(int) (y2 * yRatio));
			HSSFSimpleShape shape2 = patriarch.createSimpleShape(a2);
			shape2.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
			x1 += 10;
			x2 += 10;
		}

		// 画横线
		int x11 = 0;
		int y11 = 0;
		int x21 = 200;
		int y21 = 0;
		for (int i = 0; i < linesCount; i++) {
			HSSFClientAnchor a2 = new HSSFClientAnchor();
			a2.setAnchor((short) 2, 2, (int) (x11 * xRatio), (int) (y11 * yRatio), (short) 2, 2, (int) (x21 * xRatio),
					(int) (y21 * yRatio));
			HSSFSimpleShape shape2 = patriarch.createSimpleShape(a2);
			shape2.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
			y11 += 10;
			y21 += 10;
		}

	}

	// 5插入图片
	public void insertPic() throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// 创建工作表（Sheet）
		FileInputStream stream = new FileInputStream("d:\\a.gif");
		byte[] bytes = new byte[(int) stream.getChannel().size()];
		stream.read(bytes);// 读取图片到二进制数组
		int pictureIdx = workbook.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_JPEG);
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 0, 0, (short) 5, 5);
		HSSFPicture pict = patriarch.createPicture(anchor, pictureIdx);
		// pict.resize();//自动调节图片大小，图片位置信息可能丢失
	}

	// 6从Excel文件提取图片
	public void abstractPic() throws IOException {
		String filePath = "D:\\a.xls";
		InputStream inp = new FileInputStream(filePath);
		HSSFWorkbook workbook = new HSSFWorkbook(inp);// 读取现有的Exce文件
		List<HSSFPictureData> pictures = workbook.getAllPictures();
		for (int i = 0; i < pictures.size(); i++) {
			HSSFPictureData pic = pictures.get(i);
			String ext = pic.suggestFileExtension();
			if (ext.equals("png"))// 判断文件格式
			{
				FileOutputStream png = new FileOutputStream("d:\\a.png");
				png.write(pic.getData());
				png.close();// 保存图片
			}
		}
	}

	// Excel表操作
	// 1设置默认工作表
	public void setDefaultSheet() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（Workbook）
		workbook.createSheet("test0");// 创建工作表（Sheet）
		workbook.createSheet("test1");// 创建工作表（Sheet）
		workbook.createSheet("test3");// 创建工作表（Sheet）
		workbook.setActiveSheet(2);// 设置默认工作表
	}

	// 2重命名工作表
	public void renameSheet() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		workbook.createSheet("Test1");// 创建工作表（sheet）
		workbook.setSheetName(1, "1234");// 重命名工作表
	}

	// 3调整表单显示比例
	public void changeDisplay() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet1 = workbook.createSheet("Test0");// 创建工作表（sheet）
		HSSFSheet sheet2 = workbook.createSheet("Test1");// 创建工作表（sheet）
		HSSFSheet sheet3 = workbook.createSheet("Test2");// 创建工作表（sheet）
		sheet1.setZoom(1, 2);// 50%显示比例
		sheet2.setZoom(2, 1);// 200%显示比例
		sheet3.setZoom(1, 10);// 10%显示比例
	}

	// 4显示/隐藏网格线
	public void setGridLinesDisplayorNot() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet1 = workbook.createSheet("Test0");// 创建工作表（sheet）
		HSSFSheet sheet2 = workbook.createSheet("Test1");// 创建工作表（sheet）
		sheet1.setDisplayGridlines(false);// 隐藏Excel网格线，默认值为true
		sheet2.setGridsPrinted(true);// 打印时显示网格线，默认值为false
	}

	// 5遍历sheet
	public void traverseSheet() throws IOException {
		String filePath = "d:\\sample.xls";
		FileInputStream stream = new FileInputStream(filePath);
		HSSFWorkbook workbook = new HSSFWorkbook(stream);// 读取现有的Excel
		HSSFSheet sheet = workbook.getSheet("Test0");// 得到指定名称的sheet
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print(cell + "\t");
			}
			System.out.println();
		}
	}

	// Excel行列操作
	// 1组合行、列
	public void compositeRowAndColumn() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet("Test0");// 创建工作表（sheet）
		sheet.groupRow(1, 3);// 组合行
		sheet.groupRow(2, 4);// 组合行
		sheet.groupColumn(2, 7);// 组合列
	}

	// 2锁定列
	public void freezeCloumn() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet("Test0");// 创建工作表（sheet）
		sheet.createFreezePane(2, 3, 15, 25);// 冻结行列
	}

	// 3上下移动行
	public void moveUpAndDownRow() throws IOException {
		String filePath = "d:\\sample.xls";
		FileInputStream stream = new FileInputStream(filePath);
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet("Test0");// 创建工作表（sheet）
		sheet.shiftRows(2, 4, 2);// 把第3行到第4行向下移动两行
	}

	// Excel的其他功能
	// 1设置密码
	public void setPassword() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet("Test0");// 创建工作表（sheet）
		HSSFRow row = sheet.createRow(1);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue("已锁定");
		HSSFCellStyle locked = workbook.createCellStyle();
		locked.setLocked(true);// 设置锁定
		cell.setCellStyle(locked);
		cell = row.createCell(2);
		cell.setCellValue("未锁定");
		HSSFCellStyle unlocked = workbook.createCellStyle();
		unlocked.setLocked(false);// 设置不锁定
		cell.setCellStyle(unlocked);
		sheet.protectSheet("password");// 设置保护密码
	}

	// 2数据有效性
	public void dataValidate() {
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet("Test0");// 创建工作表（sheet）
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("日期列");
		CellRangeAddressList regions = new CellRangeAddressList(1, 65535, 0, 0);// 选定一个区域
		DVConstraint constraint = DVConstraint.createDateConstraint(DVConstraint.OperatorType.BETWEEN, "1993-01-01",
				"2014-12-31", "yyyy-MM-dd");
		HSSFDataValidation dataValidate = new HSSFDataValidation(regions, constraint);
		dataValidate.createErrorBox("错误", "你必须输入一个时间");
		sheet.addValidationData(dataValidate);
	}

	// 3生成下拉式菜单
	public void createDropDownMenu(){
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet("Test0");// 创建工作表（sheet）
		
		CellRangeAddressList regions=new CellRangeAddressList(1,65535,0,0);//选定一个区域
		DVConstraint constraint=DVConstraint.createExplicitListConstraint(new String[]{"C++","java","C#"});
		HSSFDataValidation dataValidate=new HSSFDataValidation(regions, constraint);
		sheet.addValidationData(dataValidate);
	}
	//4打印基本设置
	public void printSet(){
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet("Test0");// 创建工作表（sheet）
		
		HSSFPrintSetup print=sheet.getPrintSetup();//得到打印对象
		print.setLandscape(false);//true,则表示页面方向为横向，否则为纵向
		print.setScale((short)80);//缩放比例80%（设置为0-100之间的值）
		print.setFitWidth((short)2);//设置页宽
		print.setFitHeight((short)4);//设置页高
		print.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);//纸张设置
		print.setUsePage(true);//社会打印起始页码不使用“自动”
		print.setPageStart((short)6);//设置打印起始页码
		sheet.setPrintGridlines(true);//设置打印网格线
		print.setNoColor(true);//值为true时，表示单色打印
		print.setDraft(true);//值为true时，表示用草稿品质打印
		print.setLeftToRight(true);//true表示“先行后列”；false表示“先列后行”
		print.setNotes(true);//设置打印批注
		sheet.setAutobreaks(false);//Sheet页自适应页面大小
	}
	
	//5超链接
	public void hyperLink(){
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件（workbook）
		HSSFSheet sheet = workbook.createSheet("Test0");// 创建工作表（sheet）
		
		CreationHelper createHelper=workbook.getCreationHelper();
		//关联到网站
	    Hyperlink link=createHelper.createHyperlink(Hyperlink.LINK_URL);
		link.setAddress("http://poi.apache.org/");
		sheet.createRow(0).createCell(0).setHyperlink(link);
		//关联到当前目录的文件
		link=createHelper.createHyperlink(Hyperlink.LINK_FILE);
		link.setAddress("sample.xls");
		sheet.createRow(0).createCell(1).setHyperlink(link);
		//e-mail关联
		link=createHelper.createHyperlink(Hyperlink.LINK_EMAIL);
		link.setAddress("mailto:123@123.com?subject=Hyperlinks");
		sheet.createRow(0).createCell(2).setHyperlink(link);
		//关联到工作簿中位置
		link=createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);
		link.setAddress("'test0'!C3");//sheet名为test0的C3位置
		sheet.createRow(0).createCell(3).setHyperlink(link);
		
	}
	
	
	
	
}
