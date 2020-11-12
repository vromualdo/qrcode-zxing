# QRCode ZXing

### Utilitário QRCodeUtil - QRCode utilizando ZXing
* método createSaveQRCode(final String data, final String filePath)  - cria e salva uma imagem QRCode, com a informação desejada e no diretório informado (com o tamanho default de 200x200)
* método createSaveQRCode(final String data, final String filePath, final int height, final int width)   - cria e salva uma imagem QRCode, com a informação desejada e no diretório informado, com a altura e largura deseja
* método generateBase64QRCode(final String data) - retorna um base64 do QRCode com o conteúdo informado e o tamanho de 200x200
* método generateBase64QRCode(final String data, final int height, final int width)  - retorna um base64 do QRCode com o conteúdo informado, com a altura e largura deseja
* método readQRCodeContent(final String filePath) - retorna o conteúdo do texto atrelado a imagem QRCode informada
