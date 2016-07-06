package threadsAssignment;

//Data Structure List used for implementation of a buffer
public class ListDataStructure {

private static int index =0;
private int maxSize;
private int[] arr;
	
	public ListDataStructure(int size){
		this.maxSize =size;
		arr = new int[size];
	}
	public void add(int a){
		arr[index]=a;
		index++;
	}
	public int remove(){
		int value = arr[0];
		for(int i=0;i<arr.length-1;i++){
			arr[i]=arr[i+1];
		}
		arr[maxSize-1]=0;
		index--;
		return value;
	}
}
