package com.xuanwu.msggate.mosmto.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qts
 * @des 读写属性文件。
 * @date 2015-10-12
 */
public class readAndUpdate {

	private static final Logger logger = LoggerFactory.getLogger(readAndWriteFile.class);
	private static String maxReportId;
	private static String maxMoId;

	public static void main(String[] args) {
		String path = "./src/main/resources/maxId.properties";
		long maxMoId = 888888;
		updateProperties(path, String.valueOf(maxMoId), enumMaxIdType.maxReportId);
		System.out.println("maxMoId:" + readProperties(path, enumMaxIdType.maxMoId) + "\nmaxReportId:"
				+ readProperties(path, enumMaxIdType.maxReportId));
	}

	// read file
	public static long readProperties(String path, enumMaxIdType type) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(path);
			properties.load(inputStream);
			inputStream.close();
		} catch (Exception e) {
			logger.error("Failed to read file", e);
		}
		String maxReportId = properties.getProperty("maxReportId");
		String maxMoId = properties.getProperty("maxMoId");
		return type.equals(enumMaxIdType.maxReportId) ? Long.valueOf(maxReportId) : Long.valueOf(maxMoId);
	}

	/**
	 * 这里不会更新而是直接覆盖条之前的内容，如果有多个属性，都会被覆盖
	 */
	public static void writeProperties(String path, String maxId, enumMaxIdType type) {
		Properties properties = new Properties();
		try {
			OutputStream outputStream = new FileOutputStream(path);
			if (type.equals(enumMaxIdType.maxReportId)) {
				properties.setProperty("maxReportId", maxId);
				properties.store(outputStream, "Update '" + maxReportId + "' value");
			} else {
				properties.setProperty("maxMoId", maxId);
				properties.store(outputStream, "Update '" + maxMoId + "' value");
			}
			outputStream.close();
		} catch (Exception e) {
			logger.error("Failed to write file!!!", e);
		}
	}

	/**
	 * 更新properties文件的键值对
	 * 如果该主键已经存在，更新该主键的值；
	 * 如果该主键不存在，则插件一对键值。
	 */
	public static void updateProperties(String path, String maxId, enumMaxIdType type) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(path));   //这句是重点
			OutputStream outputStream = new FileOutputStream(path);
			if (type.equals(enumMaxIdType.maxReportId)) {
				properties.setProperty("maxReportId", maxId);
				properties.store(outputStream, "Update '" + maxReportId + "' value");
			} else {
				properties.setProperty("maxMoId", maxId);
				properties.store(outputStream, "Update '" + maxMoId + "' value");
			}
		} catch (Exception e) {
			logger.error("Failed to update file !!!", e);
		}
	}
}
