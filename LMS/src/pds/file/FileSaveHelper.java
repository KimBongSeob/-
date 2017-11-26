package pds.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class FileSaveHelper {
	private static Random random = new Random();

	public static String save(String directory, InputStream is) throws IOException {
		
		long currentTime = System.currentTimeMillis();
		int randomValue = random.nextInt(50); // 0~49 사이의 난수를 발생시킴
		String fileName = Long.toString(currentTime) + "_" + Integer.toString(randomValue);
		// 파일 이름이 중복되지 않게 파일명에 현재 시간값과 랜덤수를 붙여 명명한다.
		
		File file = new File(directory, fileName);
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			byte[] data = new byte[8096];
			int len = -1;
			while ((len = is.read(data)) != -1) { // 배열이 꽉 찰 때까지 데이터를 읽어 오고 더 이상 읽어 올 것이 없을 때까지 (len값이 -1이 아닐 동안)
				os.write(data, 0, len); // FileOutputStream객체에 write한다. data에 저장된 값을 0부터 len값만큼. 즉 전체 내용을 내보냄.
			}
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
				}
		}
		return file.getAbsolutePath();
	}
}
