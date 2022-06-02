package com.d2vts.pdfcreator.controller;

import com.d2vts.pdfcreator.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pdf")
public class PdfController {

    private final PdfService pdfService;

    @GetMapping(value = "/edit")
    public String edit(/*@RequestParam PdfDTO pdfDTO*/) {

        pdfService.edit();
        return "hello";
    }

}
