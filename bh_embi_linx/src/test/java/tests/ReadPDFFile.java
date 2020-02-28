package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPDFFile {

	static String filePath="C:\\Users\\bnandira\\Documents\\Enabling MBI Project\\MBI test execution and test data\\Blue team\\PI16.4\\US2318725-PRJ200555 Situs State PA 1557 Attachment on Member Authorization Letters\\5DXFPS_01_MBR_NOTIFICATION_SERVICE_1600101348.pdf";
	
	public static void main(String[] args) throws Exception {
		
		ReadPDFFile pdfRead=new ReadPDFFile();
		pdfRead.readContentsFromPdf(filePath);
	}

	public void readContentsFromPdf(String filePathForPdf) throws IOException {
		
		File file=new File(filePathForPdf);
		FileInputStream fis=new FileInputStream(file);
		
		PDDocument doc=null;
        doc=PDDocument.load(fis);
        String output=new PDFTextStripper().getText(doc);
        
        System.out.println("The content in the pdf is"+output);
		
	}

}
