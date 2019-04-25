package com.rz.iot.think.utils;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.png.PngChunkType;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.gif.GifHeaderDirectory;
import com.drew.metadata.jpeg.JpegDirectory;
import com.drew.metadata.png.PngDirectory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取图片信息工具类
 */
public class ImageUtil {

	/**
	 * 获取图片长宽信息
	 * @param is 输入流
	 * @return map 包含长宽
	 * @throws ImageProcessingException
	 * @throws IOException
	 */
	public static Map<String, Object> getImgInfo(InputStream is) throws ImageProcessingException, IOException {

		Map<String, Object> map = new HashMap<>();
		Integer imgWidth = null;
		Integer imgHeight = null;

		Metadata metadata = ImageMetadataReader.readMetadata(is);
		Iterable<Directory> directories = metadata.getDirectories();
		for (Directory directory : directories) {

			//获取图片的长、宽
			//jpeg
			if (directory instanceof JpegDirectory) {
				imgWidth = directory.getInteger(JpegDirectory.TAG_IMAGE_WIDTH);
				imgHeight = directory.getInteger(JpegDirectory.TAG_IMAGE_HEIGHT);
			}
			//png
			if (directory instanceof PngDirectory) {
				PngDirectory pngDirectory = (PngDirectory) directory;
				PngChunkType pngChunkType = pngDirectory.getPngChunkType();
				if (pngChunkType.equals(PngChunkType.IHDR)) {
					imgWidth = directory.getInteger(PngDirectory.TAG_IMAGE_WIDTH);
					imgHeight = directory.getInteger(PngDirectory.TAG_IMAGE_HEIGHT);
				}
			}
			//gif
			if (directory instanceof GifHeaderDirectory) {
				imgWidth = directory.getInteger(GifHeaderDirectory.TAG_IMAGE_WIDTH);
				imgHeight = directory.getInteger(GifHeaderDirectory.TAG_IMAGE_HEIGHT);
			}
		}
		map.put("imgWidth", imgWidth);
		map.put("imgHeight", imgHeight);
		return map;
	}
}
