package wordCount;

import java.awt.JobAttributes;
import java.io.IOException;
import java.nio.file.FileSystem;

import javax.tools.Tool;

import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.apache.commons.httpclient.URI;
import org.w3c.dom.css.Counter;

import examples.Chapter6.Item32.Text;
import freemarker.template.Configuration;

public class WordCount extends Configured implements Tool {

	public static class MyMapper extends Mapper<LongWritable,Text,Text,LongWritable>{
		 /*
         * @param KEYIN →k1 表示每一行的起始位置（偏移量offset）
         * 
         * @param VALUEIN →v1 表示每一行的文本内容
         * 
         * @param KEYOUT →k2 表示每一行中的每个单词
         * 
         * @param VALUEOUT →v2表示每一行中的每个单词的出现次数，固定值为1
         */
		protected void map(LongWritable key,Text value,Mapper<LongWrite ,Text,Text,LongWritable>.Context context)throws IOException,InterruptedException{
			Counter sensitiveCounter = context.getCounter("Sensitive Words:","Hello");
			
			String line= value.toString();
			// 这里假定Hello是一个敏感词
			if(line.contains("Hello")) {
				sensitiveCounter.increment(1L);
				
			}
			String[] spilted=line.split(" ");
			for(String word:spilted) {
				context.write(new Text(word),new LongWritable(1L));
			}
		};
		
	}
	
	
	public static class MyReducer extends Reducer<Text,LongWritable,Text,LongWritable>{
		/*
         * @param KEYIN →k2 表示每一行中的每个单词
         * 
         * @param VALUEIN →v2 表示每一行中的每个单词的出现次数，固定值为1
         * 
         * @param KEYOUT →k3表示每一行中的每个单词
         * 
         * @param VALUEOUT →v3 表示每一行中的每个单词的出现次数之和
         */
		protected void reduce(Text key,Iterable<LongWritable> values,Reduce<Text,LongWritable,Text,LongWritable>.Context context)
		throws IOException,InterruptedException{
			long count = 0L;
			for(LongWritable value:values) {
				count+=value.get();
			}
			context.write(key,new LongWritable(count));
		}
	}
	
	
	  // 输入文件路径
	public static String INPUT_PATH="hdfs://hadoop-master:9000/testdir/input/words.txt";
	
	// 输出文件路径
	public static String OUTPUT_PATH="hdfs://hadoop-master:9000/testdir/output/wordcount";
	
	@Override
	public  int run(String[] args) throws Exception{
		// 首先删除输出路径的已有生成文件
		FileSystem fs= FileSystem.get(new URI(INPUT_PATH),getConf());
		Path outPath=new Path(OUTPUT_PATH);
		
		if(fs.exists(outPath)) {
			fs.delete(outPath,true);
		}
		Job job= new Job(getConf(),"WordCount");
		
		// 设置输入目录
		FileInputFormat.setInputPaths(job,new Path(INPUT_PATH));
		
		// 设置自定义Mapper
		job.setMapperClass(MyMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		// 设置自定义Reducer
		job.setReduceClass(MyReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		// 设置输出目录
		FileOutputFormat.setOutputPath(job,new Path(OUTPUT_PATH));
		
		System.exit(job.waitForCompletion(true)?0:1);
		return 0;
		
	}
	
	public static void main(String[] args) {
		Configuration conf=new Configuration();
		try {
			int res=ToolRunner.run(conf,new WordCount(),args));
			System.exit(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
