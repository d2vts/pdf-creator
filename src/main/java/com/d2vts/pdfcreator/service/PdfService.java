package com.d2vts.pdfcreator.service;

import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class PdfService {

    public Map<String, Object> edit(/*PdfDTO pdfDTO*/) {

        String pdfPath = "src/main/resources/static/pdf/application.pdf";
        try (PDDocument pdfDocument = PDDocument.load(new File(pdfPath))) {

            PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

            if (acroForm != null) {
                PDTextField field = (PDTextField) acroForm.getField("organization");
                String str = new COSString("BB22BB22").getString();
                String str2 = new COSString("BB22BB22").getASCII();
                byte[] str3 = new COSString("BB22BB22").getBytes();
                String str4 = new COSString(str3).toString();
                String str5 = new COSString(str3).getString();

                field.setValue("123123");

                PDField field2 = acroForm.getField("name");
                field2.setValue("234234");

                PDField field3 = (PDField) acroForm.getField("officeAddress");
                field3.setValue("345345");

                PDTextField field4 = (PDTextField) acroForm.getField("tel");
                field4.setValue("234234");

                pdfDocument.save("src/main/resources/static/pdf/application4.pdf");
                pdfDocument.close();
            }
        } catch (IOException ioe) {

        }

        return null;
    }

}
