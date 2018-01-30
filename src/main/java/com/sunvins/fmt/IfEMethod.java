package com.sunvins.fmt;

import java.util.List;

import com.sunvins.helper.StrHelper;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class IfEMethod implements TemplateMethodModelEx {  
    public IfEMethod() {  
    }  
  
    @Override  
    public Object exec(List args) throws TemplateModelException {  
    	boolean isLeft=false;
        if(args!=null) {
    		if(TemplateBooleanModel.TRUE==args.get(0)) {
    			isLeft=true;
    		}else if(TemplateBooleanModel.FALSE==args.get(0)) {
    			isLeft=false;
    		}else {
    			SimpleScalar haStr = (SimpleScalar)args.get(0);  
    			isLeft=!StrHelper.isBlank(haStr.getAsString());
    		}
    		if(isLeft) {
    			return args.get(1);
    		}else {
    			if(args.size()==3) {
    				return args.get(2);
    			}
    		}
        }
        return "";
    } 
}
