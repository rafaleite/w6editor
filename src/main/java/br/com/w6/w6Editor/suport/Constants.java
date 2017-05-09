package br.com.w6.w6Editor.suport;

import java.io.File;

public class Constants {
	
	public static final String ACTION_ABRIR_MINUTA = "abrirminuta";
	
	public static final String ACTION_ENVIAR_MINUTA = "enviarminuta";
	
	public static final String ACTION_SUBSTITUIR_MINUTA = "substituirminuta";
	
	public static final String ACTION_ABRIR_CERTIDAO = "abrircertidao";
	
	public static final String ACTION_ENVIAR_CERTIDAO = "enviarcertidao";
	
	public static final String ACTION_SUBSTITUIR_CERTIDAO = "substituircertidao";
	
	public static final String PATH_MAIN = new StringBuilder("/Users/rafael/w6").append(File.separator).append("W6Editor").toString();
	
	public static final String PATH_MINUTAS = new StringBuilder(PATH_MAIN).append(File.separator).append("minuta").toString();
	
	public static final String PATH_CERTIDAO = new StringBuilder(PATH_MAIN).append(File.separator).append("certidao").toString();
	
	public static final String PATH_BKP_MINUTA = new StringBuilder(PATH_MINUTAS).append(File.separator).append("bkp").toString();
	
	public static final String PATH_BKP_CERTIDAO = new StringBuilder(PATH_CERTIDAO).append(File.separator).append("bkp").toString();
	
}
