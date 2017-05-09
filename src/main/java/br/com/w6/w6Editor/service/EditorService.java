package br.com.w6.w6Editor.service;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.websocket.api.Session;

import com.google.gson.Gson;

import br.com.w6.w6Editor.model.FileJSON;
import br.com.w6.w6Editor.suport.Constants;

public class EditorService {

	private Session websocketSession;

	public EditorService(Session websocketSession) {
		this.websocketSession = websocketSession;
	}
	

	/**
	 * @param pFileJson
	 * @param mSession
	 */
	public void manager(FileJSON pFileJson, Session mSession) {

		if (Constants.ACTION_ABRIR_MINUTA.equals(pFileJson.getCommand())) {
			this.openFile(pFileJson);
		
		} else if(Constants.ACTION_ENVIAR_MINUTA.equals(pFileJson.getCommand())) {


		} else if (Constants.ACTION_SUBSTITUIR_MINUTA.equals(pFileJson.getCommand())) {

			
		} else {
			sendResponse(new FileJSON(400, "Comando não localizado"));
		}

	}

	
	/**
	 * @param pFileJson
	 */
	private void openFile(FileJSON pFileJson) {
		String filePath = this.getFullPath(pFileJson.getFolder())+pFileJson.getFileName();
		File arquivo = new File(filePath);
		
		if(arquivo.exists()) {
			sendResponse(new FileJSON(35, "O arquivo já existe, envie a confirmação para substituir"));
			return;
		}
		
		if(pFileJson.getBase64File() == null || (pFileJson.getBase64File() != null && pFileJson.getBase64File().isEmpty())) {
			sendResponse(new FileJSON(400, "Ocorreu um erro ao abrir o arquivo"));
		}
		
		try {
			FileUtils.writeByteArrayToFile(arquivo, Base64.decodeBase64(pFileJson.getBase64File()));
			Desktop.getDesktop().open(arquivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void sendResponse(FileJSON response) {
		Gson gson = new Gson();
		try {
			this.getWebsocketSession().getRemote().sendString(gson.toJson(response));
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao enviar o response");
		}
	}

	
	/**
	 * @param pFileJson
	 */
	private void sendFile(FileJSON pFileJson) {
		File file = new File(this.getFullPath(pFileJson.getFolder())+pFileJson.getFileName());
		
		Gson gson = new Gson();
		try {
			byte[] data = Files.readAllBytes(file.toPath());
			
			ByteBuffer byteBuffer = ByteBuffer.wrap(data);
			
			pFileJson.setBase64File(Base64.encodeBase64String(data));
			pFileJson.setStatus(200);
			pFileJson.setMessage("Arquivo enviado com sucesso");
			
			this.getWebsocketSession().getRemote().sendString(gson.toJson(pFileJson));
			byteBuffer.clear();
			
		} catch (IOException e) {
			sendResponse(new FileJSON(400, "Ocorreu um erro ao retornar o arquivo"));
		}
		
	}

	
	/**
	 * 
	 */
	private void backupFile(File pArquivo) {

	}

	
	/**
	 * @param pFolder
	 */
	private void verifyFolder(String pFolder) {

	}
	

	/**
	 * @param pFolder
	 */
	private void isFolderExists(String pFolder) {

	}
	

	/**
	 * @param pFileJson
	 * @return
	 */
	private boolean isFileLocked(File pFile) {
		return false;
	}
	

	/**
	 * @return
	 */
	public Session getWebsocketSession() {
		return websocketSession;
	}
	

	/**
	 * @param pFolder
	 * @return
	 */
	public String getFullPath(String pFolder) {
		StringBuilder path = new StringBuilder(Constants.PATH_MAIN).append(File.separator).append(pFolder)
				.append(File.separator);
		return path.toString();
	}

}
