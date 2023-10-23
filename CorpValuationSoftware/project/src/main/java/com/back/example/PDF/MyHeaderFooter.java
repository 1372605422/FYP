package com.back.example.PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;

public class MyHeaderFooter extends PdfPageEventHelper {
  
    PdfTemplate totalPage;
    Font hfFont;
    {
        try {
            hfFont = new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED), 8, Font.NORMAL);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void onOpenDocument(PdfWriter writer, Document document) {
        PdfContentByte cb =writer.getDirectContent();
        totalPage = cb.createTemplate(30, 16);
    }
    
    public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable table = new PdfPTable(3);
        try {
            table.setTotalWidth(PageSize.A4.getWidth() - 100);
            table.setWidths(new int[] { 24, 24, 3});
            table.setLockedWidth(true);
            table.getDefaultCell().setFixedHeight(-10);
            table.getDefaultCell().setBorder(Rectangle.BOTTOM);

            table.addCell(new Paragraph(  "", hfFont));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(new Paragraph("page " + writer.getPageNumber() + "/", hfFont));
            // 
            PdfPCell cell = new PdfPCell(Image.getInstance(totalPage));

            cell.setBorder(Rectangle.BOTTOM);
            table.addCell(cell);
            // 
            table.writeSelectedRows(0, 1, 50,40, writer.getDirectContent());
        } catch (Exception de) {
            throw new ExceptionConverter(de);
        }
    }

    // 
    public void onCloseDocument(PdfWriter writer,Document document) {
        String text = "of " + (writer.getPageNumber()) ;
        ColumnText.showTextAligned(totalPage, Element.ALIGN_LEFT, new Paragraph(text,hfFont), 2, 2, 0);
    }

}
