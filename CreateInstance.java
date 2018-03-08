package practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * @author iSandeep Demonstrate the 5 ways to create instance of Class class.
 */

public class CreateInstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Way 1: create instance using new keyword.
		DemoClass way1 = new DemoClass();

		// way2: using newInstance() method
		try {
			DemoClass way2 = DemoClass.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// way3: using newInstance() method of Constructor class
		Constructor<DemoClass> constructor;
		DemoClass way3 = null;
		try {
			constructor = DemoClass.class.getConstructor();
			way3 = constructor.newInstance();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// way4: using clone() method
		// note: to use clone DemoClass must implement Cloneable and define the clone
		// method.
		try {
			DemoClass way4 = (DemoClass) way3.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// way5: using deserialization.
		// Note: To deserialize an object we need to implement a Serializable interface
		// in our class.
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream("data.obj"));
			DemoClass way5 = (DemoClass) in.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class DemoClass implements Cloneable, Serializable {
	DemoClass() {
		System.out.println("Constructor called...");
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
