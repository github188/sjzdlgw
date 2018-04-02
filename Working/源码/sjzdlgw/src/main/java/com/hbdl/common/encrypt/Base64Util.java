package com.hbdl.common.encrypt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.UrlBase64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* @ClassName: Base64Util 
* @Description: TODO(BASE64编码解码工具包) 
 * <p>BASE64编码解码工具包</p>
 * <p>依赖bcprov-jdk15on-1.52.jar</p>
* @author ql
* @date 2015年7月3日 下午2:05:33 
*
 */
public class Base64Util {

	private static final Logger logger = LoggerFactory.getLogger(Base64Util.class);

	/**
	 * 文件读取缓冲区大小
	 */
	private static final int CACHE_SIZE = 1024;


	/**
	 * <p>
	 * BASE64字符串解码为二进制数据
	 * </p>
	 * 
	 * @param base64
	 * @return
	 * @throws Exception
	 */
	public static byte[] decode( String base64 ) throws Exception {
		return Base64.decode(base64.getBytes());
	}


	/**
	 * <p>
	 * 二进制数据编码为BASE64字符串
	 * </p>
	 * 
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String encode( byte[] bytes ) throws Exception {
		return new String(Base64.encode(bytes));
	}


	/**
	 * BASE64 encrypt
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64( byte[] key ) throws Exception {
		/* 设置加密提供者，解决不同容器加密不一致问题 */
		Security.addProvider(new BouncyCastleProvider());
		byte[] b = UrlBase64.encode(key);
		return new String(b, Encoding.getEncoding());
	}


	/**
	 * BASE64 decrypt
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64( String key ) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		return UrlBase64.decode(key.getBytes(Encoding.getEncoding()));
	}


	/**
	 * <p>
	 * 将文件编码为BASE64字符串
	 * </p>
	 * <p>
	 * 大文件慎用，可能会导致内存溢出
	 * </p>
	 * 
	 * @param filePath 文件绝对路径
	 * @return
	 * @throws Exception
	 */
	public static String encodeFile( String filePath ) throws Exception {
		byte[] bytes = fileToByte(filePath);
		return encode(bytes);
	}


	/**
	 * <p>
	 * BASE64字符串转回文件
	 * </p>
	 * 
	 * @param filePath 文件绝对路径
	 * @param base64 编码字符串
	 * @throws Exception
	 */
	public static void decodeToFile( String filePath, String base64 ) throws Exception {
		byte[] bytes = decode(base64);
		byteArrayToFile(bytes, filePath);
	}


	/**
	 * 文件绝对路径
	 * <p>
	 * @param linuxDir
	 * 				linux存放目录
	 * @param winDir
	 * 				win存放目录
	 * @param fileName
	 * 				文件名
	 * @return String
	 */
	public static String filePath( String linuxDir, String winDir, String fileName ) {
		StringBuffer bf = new StringBuffer();
		if ( "\\".equals(File.separator) ) {
			//windows
			bf.append(winDir);
		} else if ( "/".equals(File.separator) ) {
			//Linux
			bf.append(linuxDir);
		}
		bf.append(File.separator);
		bf.append(fileName);
		return bf.toString();
	}


	/**
	 * <p>
	 * 文件转换为二进制数组
	 * </p>
	 * 
	 * @param filePath 文件路径
	 * @return
	 * @throws Exception
	 */
	public static byte[] fileToByte( String filePath ) throws Exception {
		byte[] data = new byte[0];
		File file = new File(filePath);
		if ( file.exists() ) {
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
			try {
				byte[] cache = new byte[CACHE_SIZE];
				int nRead = 0;
				while ( (nRead = in.read(cache)) != -1 ) {
					out.write(cache, 0, nRead);
					out.flush();
				}
				data = out.toByteArray();
			} catch ( Exception e ) {
				logger.error("fileToByte error: ", e);
			} finally {
				out.close();
				in.close();
			}
		}
		return data;
	}


	/**
	 * <p>
	 * 二进制数据写文件
	 * </p>
	 * 
	 * @param bytes 二进制数据
	 * @param filePath 文件生成目录
	 */
	public static void byteArrayToFile( byte[] bytes, String filePath ) throws Exception {
		InputStream in = new ByteArrayInputStream(bytes);
		File destFile = new File(filePath);
		if ( !destFile.getParentFile().exists() ) {
			destFile.getParentFile().mkdirs();
		}
		destFile.createNewFile();
		OutputStream out = new FileOutputStream(destFile);
		try {
			byte[] cache = new byte[CACHE_SIZE];
			int nRead = 0;
			while ( (nRead = in.read(cache)) != -1 ) {
				out.write(cache, 0, nRead);
				out.flush();
			}
		} catch ( Exception e ) {
			logger.error("byteArrayToFile error: ", e);
		} finally {
			out.close();
			in.close();
		}
	}

	public static void main(String args[]){
		String str = "asdf";
		
		try {
			String encode = encode(str.getBytes());
			String decode = new String(decode(encode));
			System.out.println(encode);
			System.out.println(decode);
			
			String encryptBASE64 = encryptBASE64(str.getBytes());
			String decryptBASE64 = new String(decryptBASE64(encryptBASE64));
			System.out.println(encryptBASE64);
			System.out.println(decryptBASE64);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
