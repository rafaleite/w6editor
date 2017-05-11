package br.com.w6.w6Editor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

import br.com.w6.w6Editor.suport.FileUtil;

public class Teste {
	
	public static void main(String[] args) {
		try {
//			byte[] byteArray = FileUtil.convertFileToByte(new File("/Users/rafael/w6/W6Editor/minuta/RAFAEL.odt"));
			
//			System.out.println(Base64.encodeBase64String(byteArray));
			
			SimpleDateFormat output = new SimpleDateFormat("yyyyMMddHHmmss");
			String formattedTime = output.format(new Date());
			
			System.out.println(formattedTime);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
