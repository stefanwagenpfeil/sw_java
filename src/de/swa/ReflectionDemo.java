package de.swa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionDemo {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("de.swa.SimpleClass");
		Object o = c.newInstance();
		
		Constructor[] cs = c.getConstructors();
		for (Constructor constr : cs) {
			Class[] paramClasses = constr.getParameterTypes();
			Object[] paramValues = new Object[paramClasses.length];
		}

		c = o.getClass();
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("test")) {
				m.invoke(o, null);
				throw new Exception("Fehler");
			}
			
			Annotation[] annotations = m.getAnnotations();
			for (Annotation a : annotations) {
				if (a.annotationType().equals("java.lang.Deprecated")) {
					
				}
			}
		}
		
		
		Runnable r = () -> System.out.println();
	}
}
