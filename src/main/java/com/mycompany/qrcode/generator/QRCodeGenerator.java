/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.qrcode.generator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    private static final Logger log = LoggerFactory.getLogger(QRCodeGenerator.class);

    public static void main(String[] args) {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode("This is a message hidden in QR Code", BarcodeFormat.QR_CODE, 350, 350);

            Path path = FileSystems.getDefault().getPath("./QRCode.png");

            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        } catch (WriterException e) {
            log.error("Could not generate QR Code, WriterException :: {}", e.getMessage());
        } catch (IOException e) {
            log.error("Could not generate QR Code, IOException :: {}", e.getMessage());
        }
    }
}
