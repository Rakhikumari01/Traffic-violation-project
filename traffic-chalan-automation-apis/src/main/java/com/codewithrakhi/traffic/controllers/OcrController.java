package com.codewithrakhi.traffic.controllers;

import com.codewithrakhi.traffic.services.OcrService;
import com.codewithrakhi.traffic.services.Seviceimpl.OcrServiceImpl;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/scan")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping(value = "/read-text")
    public String readTextFromImage(@RequestBody MultipartFile image) {

        return ocrService.readImageText(image);


    }
}
