package Tree;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//The Map output is input to Reducer and Reducer output key and output value 
public class TreeConditionReducer extends
       Reducer<Text, IntWritable, Text, IntWritable>{
	
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
	       throws IOException, InterruptedException {
		int sum = 0;
		int count=0;
		int TreeCondition;
		 for (IntWritable val : values)
		 {
			sum += val.get();           
			count++;
		 }	
		 
		 TreeCondition=sum/count;
		 
// Passing the output key and sum of the value as output value
		context.write(key, new IntWritable(TreeCondition));
		
		
	}
	
}