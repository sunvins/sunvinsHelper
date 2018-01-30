package com.sunvins.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FmtHelper {
	
	private Configuration cfg;
	
	public FmtHelper() {
		cfg = new Configuration(Configuration.VERSION_2_3_27); 
	}
	public void toShow(String fmtFileName, Object obj) {
		try {
			File file=new File(fmtFileName);
			cfg.setDirectoryForTemplateLoading(file.getParentFile());
			Template temp = cfg.getTemplate(file.getName());
			temp.process(obj, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void toFile(String fmtFileName, Object obj, String outFileName) {
		File file=new File(fmtFileName);
		FileWriter out = null;
		try {
			cfg.setDirectoryForTemplateLoading(file.getParentFile());
			Template temp = cfg.getTemplate(file.getName());
			out = new FileWriter(outFileName);
			temp.process(obj, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String toStr(String fmtStr,Object obj) {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_27); 
		StringTemplateLoader stringLoader = new StringTemplateLoader();  
		cfg.setTemplateLoader(stringLoader);  
		stringLoader.putTemplate("myTemplate",fmtStr);  
		StringWriter writer = new StringWriter(); 
		try {
			Template template = cfg.getTemplate("myTemplate","UTF-8");
			template.process(obj, writer);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} 
		return writer.toString();
	}
}
