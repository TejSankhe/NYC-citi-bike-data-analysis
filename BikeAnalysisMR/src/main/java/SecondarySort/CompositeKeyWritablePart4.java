package SecondarySort;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

public class CompositeKeyWritablePart4 implements Writable,WritableComparable<CompositeKeyWritablePart4> {

	private String stationName;
	private int tripduration;
	
	public CompositeKeyWritablePart4(){
		
	}
	
	public CompositeKeyWritablePart4(String ip, int tripduration){
		
		this.stationName=ip;
		this.tripduration=tripduration;
	}
	
	public int compareTo(CompositeKeyWritablePart4 o) {
		
		int result =stationName.compareTo(o.stationName);
		if (result==0){
			result=tripduration - o.tripduration;
		}
		return result;
	}

	public void write(DataOutput out) throws IOException {
		out.writeUTF(stationName);
		out.writeUTF(Integer.toString(tripduration));
//		WritableUtils.writeString(d, stationName);
//		WritableUtils.writeString(d, tripduration.toString());
		
//		d.writeUTF(stationName);
//		d.writeUTF(tripduration);
	}

	public void readFields(DataInput in) throws IOException {

		stationName = in.readUTF();
		tripduration = Integer.parseInt(in.readUTF());
	}
	
	public String getstationName() {
		return stationName;
	}


	public void setstationName(String stationName) {
		this.stationName = stationName;
	}

	public int gettripduration() {
		return tripduration;
	}

	public void settripduration(int tripduration) {
		this.tripduration = tripduration;
	}

	@Override
	public String toString() {
		return "CompositeKeyWritablePart4{" +
				"stationName='" + stationName + '\'' +
				", tripduration=" + tripduration +
				'}';
	}
}