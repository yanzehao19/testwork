package jvm;
/*
 * * @Described：一个艰难的决定
 */
public class OneHardMind {

	 static class QQ{}                //腾讯QQ
	      static class _360{}             //360安全卫士
	 
	     static class QQ2011 extends QQ{} //腾讯QQ2011
	 
     static class QQ2012 extends QQ{} //腾讯QQ2012
	 
	    //百度
	 
	    static class BaiDu{
	  
	       public static void choose(QQ qq){ System.out.println("BaiDu choose QQ"); }
	
	       public static void choose(QQ2011 qq){ System.out.println("BaiDu choose QQ2011"); }
	 
	        public static void choose(QQ2012 qq){ System.out.println("BaiDu choose QQ2012"); }
	 
       public static void choose(_360 _){ System.out.println("BaiDu choose 360 safe"); }
	 
    }
	
	    //迅雷
	
	     static class Thunder{
	
	        public static void choose(QQ qq){ System.out.println("Thunder choose QQ"); }
	 
	        public static void choose(QQ2011 qq){ System.out.println("Thunder choose QQ2011"); }
	 
	       public static void choose(QQ2012 qq){ System.out.println("Thunder choose QQ2012"); }
	
	        public static void choose(_360 qq){ System.out.println("Thunder choose 360 safe"); }
	 
	     }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BaiDu baiDu = new BaiDu();
		 
		        Thunder thunder = new Thunder();
		 
		        QQ qq = new QQ();
		 
		        _360 _360_safe = new _360();
		 
		        baiDu.choose(qq);
		 
		        thunder.choose(_360_safe);
		 
		        qq = new QQ2011();
		
		       baiDu.choose(qq);
		 
		        qq = new QQ2012();
		 
		        baiDu.choose(qq);
	}

}
