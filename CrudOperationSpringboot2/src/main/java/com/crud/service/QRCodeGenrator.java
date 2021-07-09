package com.crud.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRCodeGenrator {
	
	
	public byte[] generateQRImage(String value) throws WriterException, IOException{
		
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bitmatrix= writer.encode(value,BarcodeFormat.QR_CODE, 400, 400);
		
		ByteArrayOutputStream ot= new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitmatrix, "PNG", ot);
		
		return ot.toByteArray();
		
		
	}

}
