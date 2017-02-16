package adapter.pattern;

public class MediaAdapter implements MediaPlayer {
	AdvancedMediaPlayer advancedMediaPlayer;
	
	public MediaAdapter(String audioType){
		if(audioType.equalsIgnoreCase("VIc")){
			advancedMediaPlayer=new VIcPlayer();
			
		}else if(audioType.equalsIgnoreCase("mp4")){
			advancedMediaPlayer=new Mp4Player();
		}
	}
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("VIc")){
			advancedMediaPlayer.playVIc(fileName);
			
		}else if(audioType.equalsIgnoreCase("mp4")){
			advancedMediaPlayer.playMp4(fileName);
		}
	}

}
