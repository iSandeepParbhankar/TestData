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

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException,
			/**/
			CloneNotSupportedException, 
			FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		// Way 1: create instance using new keyword.
		DemoClass way1 = new DemoClass();

		// way2: using newInstance() method
		DemoClass way2 = DemoClass.class.newInstance();

		// way3: using newInstance() method of Constructor class
		Constructor<DemoClass> constructor = DemoClass.class.getConstructor();
		DemoClass way3 = constructor.newInstance();

		// way4: using clone() method
		// note: to use clone DemoClass must implement Cloneable and define the clone
		// method.
		DemoClass way4 = (DemoClass) way3.clone();

		// way5: using deserialization.
		// Note: To deserialize an object we need to implement a Serializable interface
		// in our class.
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
		DemoClass way5 = (DemoClass) in.readObject();
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