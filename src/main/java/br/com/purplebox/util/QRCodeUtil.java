package br.com.purplebox.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.beust.jcommander.ParameterException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeUtil {
	
	
	private static final Integer DEFAULT_QRCODE_HEIGHT = 200;
	
	private static final Integer DEFAULT_QRCODE_WIDTH = 200;

	/**
	 * Creates and saves the qrcode image in the destination folder(img 200x200)
	 * 
	 * @param data - contend QRCode
	 * @param filePath - file destination path 
	 * @throws ParameterException
	 * @throws WriterException
	 * @throws IOException
	 * @throws Exception
	 */
	public void createSaveQRCode(final String data, final String filePath) throws ParameterException, WriterException, IOException, Exception {
		this.createSaveQRCode(data, filePath, DEFAULT_QRCODE_HEIGHT, DEFAULT_QRCODE_WIDTH); 
	}
	
	/**
	 * 
	 * Creates and saves the qrcode image in the destination folder
	 * 
	 * @param data - contend QRCode
	 * @param filePath - file destination path 
	 * @param height - file height 
	 * @param width - file with
	 * @throws ParameterException
	 * @throws WriterException
	 * @throws IOException
	 * @throws Exception
	 */
	public void createSaveQRCode(final String data, final String filePath, final int height, final int width) 
			throws ParameterException, WriterException, IOException, Exception {
		
		this.validateParameters(data, filePath, height, width);
		
		// Encoding charset
		String charset = "UTF-8";

		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
		BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, width, height);
		
		String format = filePath.substring(filePath.lastIndexOf('.') + 1);
		
		MatrixToImageWriter.writeToPath(matrix, format,  Paths.get(filePath));
		
	}
	
	/**
	 * 
	 * Generate Base64 QRCode from Content (img 200x200)
	 * 
	 * @param data - contend QRCode
	 * 
	 * @return - qrcode base64
	 * 
	 * @throws ParameterException
	 * @throws Exception
	 */
	public String generateBase64QRCode(final String data) 
			throws ParameterException, Exception {
		return this.generateBase64QRCode(data, DEFAULT_QRCODE_HEIGHT, DEFAULT_QRCODE_WIDTH); 
	}
	
	/**
	 * 
	 * Generate Base64 QRCode from Content
	 * 
	 * @param data - contend QRCode
	 * @param height - file height 
	 * @param width - file with
	 * 
	 * @return - qrcode base64
	 * 
	 * @throws ParameterException
	 * @throws Exception
	 */
	public String generateBase64QRCode(final String data, final int height, final int width) 
			throws ParameterException, Exception {
		
		this.validateParameters(data, height, width);
		
		// Encoding charset
		String charset = "UTF-8";

		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
		BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, width, height);
		
		BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(matrix);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		ImageIO.write(bufferedImage, "png", os);	
		
		return Base64.getEncoder().encodeToString(os.toByteArray());
		
	}
	
	

	/**
	 * 
	 * Read QRCode content
	 * 
	 * @param filePath - file path 
	 * @return QRCode content
	 * 
	 * @throws ParameterException
	 * @throws IOException
	 * @throws Exception
	 */
	public String readQRCodeContent(final String filePath) throws ParameterException, IOException, Exception {
		
		if(filePath == null || filePath.trim().isEmpty()) {
			throw new ParameterException("FilePath Empty");
		}
		
		BinaryBitmap binaryBitmap = new BinaryBitmap(
				new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));

		Result result = new MultiFormatReader().decode(binaryBitmap);

		return result.getText();
	}
	
	/**
	 * 
	 * Validate parameters
	 * 
	 * @param data - contend QRCode
	 * @param filePath - file destination path 
	 * @param height - file height 
	 * @param width - file with
	 * 
	 * @throws ParameterException
	 */
	private void validateParameters(final String data, final String filePath, final int height, final int width) throws ParameterException {
		
		if(data == null || data.trim().isEmpty()) {
			
			throw new ParameterException("Data Empty");
		}
		
		if(filePath == null || filePath.trim().isEmpty()) {
			
			throw new ParameterException("FilePath Empty");
		}
		
		if(height <= 0) {
			
			throw new ParameterException("height less than 1 pixel");
		}
		
		if(width <= 0) {
			
			throw new ParameterException("height less than 1 pixel");
		}
	}
	
	/**
	 * 
	 * Validate parameters
	 * 
	 * @param data - contend QRCode
	 * @param filePath - file destination path 
	 * @param height - file height 
	 * @param width - file with
	 * 
	 * @throws ParameterException
	 */
	private void validateParameters(final String data, final int height, final int width) throws ParameterException {
		
		if(data == null || data.trim().isEmpty()) {
			
			throw new ParameterException("Data Empty");
		}
		
		if(height <= 0) {
			
			throw new ParameterException("height less than 1 pixel");
		}
		
		if(width <= 0) {
			
			throw new ParameterException("height less than 1 pixel");
		}
	}

}
