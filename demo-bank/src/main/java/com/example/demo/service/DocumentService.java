package com.example.demo.service;

import com.example.demo.dto.ReporteDTO;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
public class DocumentService {

    public String generatePdfReport(ReporteDTO reporte) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Reporte de Movimientos"));
        reporte.getMovimientos().forEach(m -> {
            document.add(new Paragraph("Fecha: " + m.getFecha() + ", Tipo: " + m.getTipoMovimiento() + ", Valor: " + m.getValor()));
        });
        document.add(new Paragraph("Total Créditos: " + reporte.getTotalCreditos()));
        document.add(new Paragraph("Total Débitos: " + reporte.getTotalDebitos()));

        document.close();
        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }
}
