package com.d2vts.pdfcreator.controller;

import com.d2vts.pdfcreator.dto.PdfDTO;
import com.d2vts.pdfcreator.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pdf")
public class PdfController {

    private final PdfService pdfService;

    /** resource/static/pdf/request.json 참고 */
    @PostMapping("")
    public String edit(@RequestBody PdfDTO pdfDTO) {
        pdfService.edit(pdfDTO);
        return "complete";
    }

}
