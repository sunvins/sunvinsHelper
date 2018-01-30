<#import "s3.fmt" as s3>
package com.sunvins.model;
<#list impSet as importValue>
import ${importValue!};
</#list>

public class ${voName}VO {
<@s3.field fieldList/>

<@s3.setget fieldList/>
}