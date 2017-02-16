package adapter.pattern;

public class VIcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVIc(String fileName) {
		System.out.println("Playing vlc file. Name: "+fileName);
	}

	@Override
	public void playMp4(String fileName) {
		 //什么也不做
	}

}
