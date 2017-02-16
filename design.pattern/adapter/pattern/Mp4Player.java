package adapter.pattern;

public class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVIc(String fileName) {
		 //什么也不做
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: "+fileName);
	}

}
