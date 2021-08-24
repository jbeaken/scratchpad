package org.mzuri.scratchpad;

public class Types {
	
	Object[] array;

    public static void main(String[] args) {
    	
    	char c =  '\u041f';
    	
    	System.out.println( c );
    	
    	float f = 3;
    	short s = 45;

    	long b = 450000000l;
    	
    	s = (short)(s  + b);
    	
    }
    
    private static void change(Table t) {
    	t = new Table();
    	t.setLength(34);
    }
}

class Table {
	int length;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	
}


