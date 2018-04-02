package com.hbdl.common.base;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * UploadFile.
 */
public class UploadFile {

	private String parameterName;  //参数名称,表单name值

	private String saveDirectory; //保存路径
	private String fileName;  //文件名字
	private String originalFileName;  //原文件名称
	private String contentType; //类型
	private String fileSurfix; //文件后缀

	public UploadFile(String parameterName, String saveDirectory, String fileName, String originalFileName,
			String contentType, String fileSurfix) {
		this.parameterName = parameterName;
		this.saveDirectory = saveDirectory;
		this.fileName = fileName;
		this.originalFileName = originalFileName;
		this.contentType = contentType;
		this.fileSurfix = fileSurfix;
	}

	/**
	 * 获取存储文件的全名（文件名加后缀）
	 * @return
	 */
	public String fileFullName() {
		return getFileName() + "." + getFileSurfix();
	}
	
	public String getParameterName() {
		return parameterName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileSurfix() {
		return fileSurfix;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public String getContentType() {
		return contentType;
	}

	public String getSaveDirectory() {
		return saveDirectory;
	}

	public File getFile() {
		if (saveDirectory == null || fileName == null) {
			return null;
		} else {
			return new File(saveDirectory + File.separator + fileName);
		}
	}
	
	
	/**
	 * 创建缩略图
	 * @author : wangmingming
	 * @date : 2015年8月7日上午10:09:53
	 * @param fi 原图
	 * @param fo 缩略图
	 */
	public static void createPreviewImage(File fi, File fo ) {   
        try {   
            BufferedImage bis = ImageIO.read(fi);   
            int w = bis.getWidth();   
            int h = bis.getHeight();   
//            double scale = (double) w / h;   
            int nw = 200; // 宽
            int nh = (nw * h) / w;   
            if (nh > nw) {   
                nh = nw;   
                nw = (nh * w) / h;   
            }   
//            int sx = nw / w;   
//            int sy = nh / h;   
//  
//            AffineTransform transform = new AffineTransform();  
//            transform.setToScale(sx, sy);   
//            AffineTransformOp ato = new AffineTransformOp(transform, null);   
//            BufferedImage bid = new BufferedImage(nw, nh,   
//                    BufferedImage.TYPE_3BYTE_BGR);   
//            ato.filter(bis, bid);   
//            ImageIO.write(bid, "png", fo);  
            Thumbnails.of(fi.getPath()).size(nw, nh).keepAspectRatio(false).toFile(fo);
        } catch (Exception e) {   
            e.printStackTrace();   
            throw new RuntimeException(   
                    " Failed create preview image. Error:  " 
                            + e.getMessage()); 
        }
    }
	
	public static void main(String[] args) {
		File fi = new File("D:/image2.png"); //大图文件
		File fo = new File("D:/imgTest.png"); //将要转换出的小图文件
		createPreviewImage(fi, fo);
	}
}
