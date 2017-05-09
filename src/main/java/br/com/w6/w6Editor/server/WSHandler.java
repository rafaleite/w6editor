package br.com.w6.w6Editor.server;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import com.google.gson.Gson;

import br.com.w6.w6Editor.model.FileJSON;
import br.com.w6.w6Editor.service.EditorService;

@WebSocket
public class WSHandler extends WebSocketHandler {

	private Session mSession;

	private static ArrayList<WSHandler> sessions = new ArrayList<WSHandler>();

	private EditorService editorService;

	public static ArrayList<WSHandler> getAllSessions() {
		return sessions;
	}

	@OnWebSocketClose
	public void onClose(int statusCode, String reason) {
		sessions.remove(this);
		System.out.println(
				"Close: statusCode = " + statusCode + ", reason = " + reason + ", sessions = " + sessions.size());
	}

	@OnWebSocketError
	public void onError(Throwable t) {
		System.out.println("Error: " + t.getMessage());
	}

	@OnWebSocketConnect
	public void onConnect(Session session) {
		mSession = session;
		sessions.add(this);
		editorService = new EditorService(mSession);

		System.out.println("Connect: " + session.getRemoteAddress().getAddress());
	}

	@OnWebSocketMessage
	public void onMessage(String message) {
		
		System.out.println("Message: " + message);

		if (mSession != null) {
			System.out.println("session: " + mSession);
			
			Gson gson = new Gson();
			FileJSON arquivo = gson.fromJson(message, FileJSON.class);
			
			this.editorService.manager(arquivo,mSession);
			
//			try {
//				Desktop.getDesktop().open(new File("/Users/rafael/w6/arquivos/notas/ESCRITURA_PUBLICA_DE_ADITAMENTO_E_RATIFICACAO.odt"));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
//			try {
//				mSession.getRemote().sendString("INICIANDO SCANNER ...");
//				Desktop.getDesktop().open("/Users/rafael/");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}

	@Override
	public void configure(WebSocketServletFactory factory) {
		factory.register(WSHandler.class);
	}

	public void sendImage(String pNameFile, byte[] data) {
		if (mSession == null)
			return;

//		try {
//			ByteBuffer byteBuffer = ByteBuffer.wrap(data);
//			
//			FileJSON newFile = new FileJSON(pNameFile, Base64.encodeBase64String(data));
//			Gson gson = new Gson();
//			mSession.getRemote().sendString(gson.toJson(newFile));
//			byteBuffer.clear();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public void readFolder() {
//		File folder = new File(Constants.PATH_IMG_SCAN);
//		
//		File[] listOfFiles = folder.listFiles();
//		for (File file : listOfFiles) {
//			if (file.isFile()) {
//				try {
//					Thread.sleep(2000);
//					byte[] byteArray = FileUtil.convertFileToByte(file);
//					file.delete();
//				} catch (IOException e) {
//					file.delete();
//					e.printStackTrace();
//				} catch (InterruptedException e) {
//					file.delete();
//					e.printStackTrace();
//				}
//			}
//		}
	}
	

}