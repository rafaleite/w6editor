package br.com.w6.w6Editor.model;

public class FileJSON {
	
	private int status;
	private String message;
	private String fileName;
	private String folder;
	private String base64File;
	private String command;
	
	public FileJSON(int status, String message, String fileName, String folder, String base64File, String command) {
		super();
		this.status = status;
		this.message = message;
		this.fileName = fileName;
		this.folder = folder;
		this.base64File = base64File;
		this.command = command;
	}
	
	public FileJSON(int pStatus, String pMessage) {
		this.status = pStatus;
		this.message = pMessage;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getBase64File() {
		return base64File;
	}
	public void setBase64File(String base64File) {
		this.base64File = base64File;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	


}
