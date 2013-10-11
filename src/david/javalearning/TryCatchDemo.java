package david.javalearning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class TryCatchDemo
{
	/*
	 * ��ȡ��IO����������ļ������ڱ��첻ͨ��
	 */
	public static void readFileTryCatch()
	{
		BufferedReader br = null;
//		BufferedReader bReader = new BufferedReader(new FileReader("IODemo.txt"));
		try
		{
			String filepath = "G:\\����\\Java\\IODemo.txt";			
			File file = new File(filepath);
			System.out.println(file.exists());
			if (file.exists())
			{
				StringBuilder sb = new StringBuilder();
				br = new BufferedReader(new FileReader(file));
				String contentString = br.readLine();
				while (contentString != null)
				{
					sb.append(contentString);
					sb.append("\n");
					contentString = br.readLine();
				}
				System.out.println(sb.toString());
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println(e.toString());
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.toString());
		} finally
		{
			try
			{
				br.close();
			} catch (IOException e)
			{
				System.out.println(e.toString());
				System.out.println(e.getMessage());
			} catch (NullPointerException e)
			{
				e.printStackTrace();
				System.out.println(e.toString());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void testThrowExceptions()
	{
		try
		{
			int number = new Random().nextInt(10);			
			System.out.println(10 / number);
		
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void testException()
	{
		try
		{
			throw new CustomException("�����Զ����쳣��");
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

	}
}
