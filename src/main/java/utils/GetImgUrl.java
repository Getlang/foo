package utils;

import java.io.File;
import java.util.List;

public class GetImgUrl {
	public static boolean processImg(String video_path,String ffmpeg_path) {
		File file = new File(video_path);
		if (!file.exists()) {//获取不到视频的情况
		System.err.println("路径[" + video_path + "]对应的视频文件不存在!");
		return false;
		}
		List<String> commands = new java.util.ArrayList<String>();
		commands.add(ffmpeg_path);
		commands.add("-i");
		commands.add(video_path);
		commands.add("-y");
		commands.add("-f");
		commands.add("image2");
		commands.add("-ss");
		commands.add("20");//这个参数是设置截取视频多少秒时的画面
		commands.add("-t");
		commands.add("0.001");
		commands.add("-s");
		commands.add("1920x1080");//图片宽X高
		//文件存储路径及格式
		commands.add(video_path.substring(0, video_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");
		ProcessBuilder builder = new ProcessBuilder();
		try {
		builder.command(commands);
		builder.start();
		System.out.println("截取成功");
		return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
		}
		public static void main(String[] args) {
			//视频路径及ffmpeg运行文件的路径
		processImg("D:/video/1.mp4","E:/ffmpeg.exe");
		}
	
}
