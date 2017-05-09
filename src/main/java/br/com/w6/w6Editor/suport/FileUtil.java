package br.com.w6.w6Editor.suport;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.stream.FileImageOutputStream;

public class FileUtil {
	
	public static byte[] convertFileToByte(File pFile) throws IOException {
		byte[] bFile = Files.readAllBytes(pFile.toPath());
		return bFile;
	}
	
	/**
	 * @param btArquivo
	 * @param nmArquivo
	 * @param diretorio
	 * @return
	 */
	public static File createFileFromByteArray(byte[] btArquivo, String nmArquivo, String diretorio) {
		
		if (!new File(diretorio).exists()) {
			(new File(diretorio)).mkdirs();
		}
		
		FileImageOutputStream imageOutput;
		
		try {
			File arquivo = new File(diretorio+File.separator+nmArquivo);
			imageOutput = new FileImageOutputStream(arquivo);
			imageOutput.write(btArquivo, 0, btArquivo.length);
			imageOutput.close();
			
			return arquivo;
		} catch (IOException e) {
			//TODO
			return null;
		}
		
	}
	
}
