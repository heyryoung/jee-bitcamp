package com.bank.web.test;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class FileTest {
	public static final String FILE_PATH = String.format("C:%sUsers%suser%seclipse-jee%sjee-bitcamp%sWebContent%sresources%stxt%s",
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator);
	
	public static void main(String...args) {
		System.out.println(">>> "+FILE_PATH);
		
		try {
			File file = new File(FILE_PATH+"list.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			List<String> list = new ArrayList<>();
			while(true) {
				switch(JOptionPane.showInputDialog("0.종료 1.저장 2.읽기")) {
				case "0": JOptionPane.showMessageDialog(null, "종료");return;
				case "1":
					String msg = JOptionPane.showInputDialog("메시지를 입력하세요. 데이터 사이에 , 입력");
					writer.write(msg);
					writer.newLine();
					writer.flush();
					break;
				case "2":
					while((msg = reader.readLine()) != null) {
						list.add(msg+"/");
					}
					JOptionPane.showMessageDialog(null, list);
					reader.close();
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}