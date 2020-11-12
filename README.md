# QRCode ZXing

### Utilitário QRCodeUtil - QRCode utilizando ZXing
* método <b>createSaveQRCode(final String data, final String filePath)</b>: cria e salva uma imagem QRCode, com a informação desejada e no diretório informado (com o tamanho default de 200x200)
* método <b>createSaveQRCode(final String data, final String filePath, final int height, final int width)</b>: cria e salva uma imagem QRCode, com a informação desejada e no diretório informado, com a altura e largura deseja
* método <b>generateBase64QRCode(final String data)</b>: retorna um base64 do QRCode com o conteúdo informado e o tamanho de 200x200
* método <b>generateBase64QRCode(final String data, final int height, final int width)</b>: retorna um base64 do QRCode com o conteúdo informado, com a altura e largura deseja
* método <b>readQRCodeContent(final String filePath)</b>: retorna o conteúdo do texto atrelado a imagem QRCode informada


###### POM (dependencies)
```xml
<dependency>
	<groupId>com.google.zxing</groupId>
	<artifactId>core</artifactId>
	<version>3.3.0</version>
</dependency>
<dependency>
	<groupId>com.google.zxing</groupId>
	<artifactId>javase</artifactId>
	<version>3.3.0</version>
</dependency>
```