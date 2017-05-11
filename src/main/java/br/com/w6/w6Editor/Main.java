package br.com.w6.w6Editor;

import java.io.File;

import br.com.w6.w6Editor.server.WebSocketServer;
import br.com.w6.w6Editor.suport.Constants;

public class Main {
	
	public static void main(String[] args) {
		
		//criando pastas
		new File(Constants.PATH_MINUTAS).mkdirs();
		new File(Constants.PATH_CERTIDAO).mkdirs();
		new File(Constants.PATH_BKP_MINUTA).mkdirs();
		new File(Constants.PATH_BKP_CERTIDAO).mkdirs();
		
		WebSocketServer mWebSocketServer = new WebSocketServer();
		mWebSocketServer.start();
	}
	
}
