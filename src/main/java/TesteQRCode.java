import br.com.purplebox.util.QRCodeUtil;

public class TesteQRCode {

	public static void main(String[] args) throws Exception {
		
		QRCodeUtil qrCodeUtil = new QRCodeUtil();
		
		String pathNovoArquivo = "C:/data/NovoArquivo.png";
		String conteudoQRCode = "Conteudo Arquivo Criado Agora";
		qrCodeUtil.createSaveQRCode(conteudoQRCode, pathNovoArquivo, 700, 700);
		System.out.println("Arquivo Criado: " + pathNovoArquivo);
		
		String pathNovoArquivo200x200 = "C:/data/NovoArquivo200x200_Default.png";
		qrCodeUtil.createSaveQRCode(conteudoQRCode, pathNovoArquivo200x200);
		System.out.println("Arquivo Criado 200x200: " + pathNovoArquivo200x200);
		
		System.out.println("");
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Conteudo do QRCode: " + qrCodeUtil.readQRCodeContent(pathNovoArquivo));
		
		System.out.println("");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String conteudoQRCodeBa64 = "O seu conteuo no QRCODE em Base64";
		System.out.println("Base64: " + qrCodeUtil.generateBase64QRCode(conteudoQRCodeBa64, 1000, 1000));
		System.out.println("------------------------------------------");
		System.out.println("Base64 200x200 (Default): " + qrCodeUtil.generateBase64QRCode(conteudoQRCodeBa64));
		
	}	
	
}
