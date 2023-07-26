package com.codewithrakhi.traffic.services.Seviceimpl;

import com.codewithrakhi.traffic.services.OcrService;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class OcrServiceImpl implements OcrService {

    @Autowired
    private Environment e;

    @Override
    public String readImageText(MultipartFile file) {


        try {
            Tesseract tesseract = new Tesseract();
            // tesseract.setDataPath(e.getProperty(key));
            tesseract.setDatapath("E:\\traffic violation project\\traffic-chalan-automation-apis\\tessdata"); // Set the path to the tessdata directory
            tesseract.setLanguage("eng"); // Set the language of the text to be extracted

            // Perform OCR on the image file
            tesseract.setPageSegMode(1);
            tesseract.setOcrEngineMode(1);
            BufferedImage image = ImageIO.read(file.getInputStream());
            String result = tesseract.doOCR(image);

            return result;

        } catch (TesseractException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "Error reading image file";
    }

}