
public class ArrayStack {
	
	static final int MAX_CAPACITY = 1000;
	static String EMPTY_MESSAGE = "stack is empty";
	
	private Object[] a;
	private int size;
	
	public ArrayStack(){
		a = new Object[MAX_CAPACITY];
	}

	public ArrayStack(int capacity) {
		a = new Object[capacity];
	}
	
	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if ( size == 0 ) throw new IllegalStateException(EMPTY_MESSAGE);
		return a[size -1];
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if ( size == 0 ) throw new IllegalStateException(EMPTY_MESSAGE);
		Object object = a[--size];
		a[size] = null;
		return object;
	}

	@Override
	public void push(Object object) {
		// TODO Auto-generated method stub
		if ( size == a.length ) resize();
		a[size++] = object;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private void resize() {
		Object[] aa= a;
		a = new Object[2 * aa.length];
		System.arraycopy(aa, 0, a, 0, size);
	}
	
	public boolean isEmpty() {
		return ( size == 0 );
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(a[size-1]);
		for( int i = size-2; i >= 0; i--){
			buf.append(","+a[i]);
		}
		return "("+buf.toString()+")";
	}
	
	public boolean equals(Object obj){
		ArrayStack temp = (ArrayStack)obj;
		int size_n1 = 0; 
		int size_n2 = 0; 
		
		for(int n = 0; n < a.length; n++ ){
			if(a[n] == null)
			break;
			size_n1 ++;
		}
		
		for(int m = 0; m < temp.a.length; m++ ){
			if(temp.a[m] == null)
			break;
			size_n2++;
		}
		
		if(size_n1 != size_n2)
			return false;
		for(int i = 0; i < size; i++){
			if(!(a[i].equals(temp.a[i])))
				return false;
			}
			return true;
	}
	
	public Object popSecond(){
		Object temp = a[size-2];
		a[size-2] = null;
		System.arraycopy(a, size-1, a, size-2, 1);
		size--;
		return temp;
	}
	
	public Object popBottom(){
		Object temp = a[0];
		a[0] = null;
		System.arraycopy(a, 1, a, 0, size-1);
		size--;
		return temp;
	}
	
}
