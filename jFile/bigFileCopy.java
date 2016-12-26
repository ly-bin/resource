package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * 
 *@author taoshengQiao
 * 
 * @description 利用管道拷贝大文件
 * 
 */
public class bigFileCopy {
	// 定义缓冲区的大小，设为一个常量。
	static final int size = 1048576;

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		//源文件和目标文件的路径
		String path1 = "e:/abc/a.txt";
		String path2 = "e:/abc/ox.txt";
		File sorFile = new File(path1);
		File disFile = new File(path2);
		//复制方法运行时间
		System.out.println("拷贝所用时间为："+bigCopy(sorFile, disFile)+"s");
		System.out.println("这个执行时间为：" + (System.currentTimeMillis() - startTime) / 1000f + "s");
	}

	/**
	 * 
	 */
	public static float bigCopy(File f1, File f2) throws Exception {
		// 获得开始拷贝的时间
		long startTime = System.currentTimeMillis();
		
		// 1M的缓冲区
		int length = size;
		FileInputStream in = new FileInputStream(f1);
		FileOutputStream out = new FileOutputStream(f2);
		FileChannel fin = in.getChannel();
		FileChannel fout = out.getChannel();
		while (true) {
			if (fin.position() == fin.size()) {
				fin.close();
				fout.close();
				// 文件拷贝完毕，关闭输入输出管道后的时间，并返回所用时间
				return (System.currentTimeMillis()-startTime)/1000f;
			}
			if ((fin.size() - fin.position()) < size)
				length = (int) (fin.size() - fin.position());
			else
				length = size;
			fin.transferTo(fin.position(), length, fout);
			fin.position(fin.position() + length);
		}
	}
}
