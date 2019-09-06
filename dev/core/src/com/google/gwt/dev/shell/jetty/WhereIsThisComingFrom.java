package com.google.gwt.dev.shell.jetty;

import java.net.URL;
import java.util.Enumeration;

public class WhereIsThisComingFrom {
	public static void main(String[] args)
	{
		locate(org.objectweb.asm.Opcodes.class);
	}

	public static void locate(Class<?> clazz)
	{
		try
		{
			ClassLoader cl = clazz.getClassLoader();
			String classAsResource = clazz.getName().replace('.', '/') + ".class";
			Enumeration<URL> urls = cl.getResources(classAsResource);
			System.out.printf("Looking for: %s%n", classAsResource);
			while (urls.hasMoreElements())
			{
				URL url = urls.nextElement();
				System.out.printf("Found: %s%n", url.toExternalForm());
			}
		}
		catch (Throwable t)
		{
			System.out.printf("Whoops: cannot locate: %s%n", clazz);
			t.printStackTrace();
		}
	}
}
