package poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.aspose.words.Row;

public class POIoperationWord {
	//poi创建word文档的简单示例
	public void createWork() throws IOException{
		XWPFDocument doc=new XWPFDocument();//创建word文件
		XWPFParagraph p=doc.createParagraph();//新建一个段落
		p.setAlignment(ParagraphAlignment.CENTER);//设置段落对齐方式
		p.setBorderBottom(Borders.DOUBLE);//设置下边框
		p.setBorderTop(Borders.DOUBLE);//设置上边框
		p.setBorderRight(Borders.DOUBLE);//设置右边框
		p.setBorderLeft(Borders.DOUBLE);//设置左边框
		XWPFRun r=p.createRun();//创建段落文本
		r.setText("poi创建的word段落文本");
		r.setBold(true);//设置为粗体
		r.setColor("FF0000");//设置颜色
		p=doc.createParagraph();//新建一个段落
		r=p.createRun();//创建段落文本
		r.setText("poi读写Excel功能强大，操作简单");
		XWPFTable table=doc.createTable(3,3);//创建一个表格
		table.getRow(0).getCell(0).setText("表格1");
		table.getRow(1).getCell(1).setText("表格2");
		table.getRow(1).getCell(2).setText("表格3");
		FileOutputStream out=new FileOutputStream("d:\\sample.doc");
		doc.write(out);
		out.close();
	}
	
	//poi读取word文档里的文字
	public void readChar() throws IOException{
		FileInputStream stream=new FileInputStream("d:\\sample.doc");
		XWPFDocument doc=new XWPFDocument(stream);//创建word文件
		for(XWPFParagraph p:doc.getParagraphs())//遍历段落
		{
			System.out.print(p.getParagraphText());
		}
		
		for(XWPFTable table:doc.getTables())//遍历表格
		{
			for(XWPFTableRow row:table.getRows()){
				for(XWPFTableCell cell:row.getTableCells()){
					System.out.print(cell.getText());
				}
			}
		}
		
		
	}
	
	
}
