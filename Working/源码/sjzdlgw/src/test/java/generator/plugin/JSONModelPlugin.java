package generator.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * mgb从新定义model生成策略，生成model对象继承子baseEntity对象，baseEntity对象继承子JSONObject,
 * 这里根据fastJson 属性， 重新生成setter、getter方法
 * 
 * @author ql
 *
 */
public class JSONModelPlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		generateToString1(introspectedTable, topLevelClass);
		return true;
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		generateToString1(introspectedTable, topLevelClass);
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		generateToString1(introspectedTable, topLevelClass);
		return true;
	}

	private void generateToString(IntrospectedTable introspectedTable,
			TopLevelClass topLevelClass) {
		// 类添加注解
		// topLevelClass.addAnnotation("@SuppressWarnings({\"unused\"})");
		// String type = introspectedTable.getBaseRecordType();
		// System.out.println(type);
		for (Field field : topLevelClass.getFields()) {
			initialSet(field, introspectedTable, topLevelClass);
		}
	}

	private void initialSet(Field field, IntrospectedTable introspectedTable,
			TopLevelClass topLevelClass) {

		// String type = introspectedTable.getBaseRecordType();
		// System.out.println("getBaseRecordType:\t" + type);

		String property = field.getName();
		FullyQualifiedJavaType field_type = field.getType();
		System.out.println("getType:\t" + field_type);
		System.out.println("getName:\t" + property);
		System.out.println("getShortName:\t" + field_type.getShortName());
		// System.out.println("getClass:\t"+field.getClass());
		// System.out.println("getVisibility:\t"+field.getVisibility());
		// System.out.println("getAnnotations:\t"+field.getAnnotations());

		String columnName = property.replaceFirst(property.substring(0, 1), property.substring(0, 1).toUpperCase());
		System.out.println(columnName);

		Method setMethod = new Method();
		setMethod.setVisibility(JavaVisibility.PUBLIC);
		setMethod.setReturnType(null);
		setMethod.setName("set" + columnName); //$NON-NLS-1$
		setMethod.addParameter(new Parameter(field_type, property));
		// setMethod.addBodyLine("// this."+property+" = " + property + "; 这里生成没有实际意义，只是为了在debug的时候看得清楚些！！");
//		setMethod.addBodyLine("this." + property + " = " + property + ";"); // this.type = type;
		setMethod.addBodyLine("this.set(\"" + property + "\"," + property + ");");
		topLevelClass.addMethod(setMethod);

		Method getMethod = new Method();
		getMethod.setVisibility(JavaVisibility.PUBLIC);
		getMethod.setReturnType(field_type);
		getMethod.setName("get" + columnName); //$NON-NLS-1$
		// getMethod.addParameter(new Parameter(field_type, property));
		// getMethod.addBodyLine("return this.get"+field_type.getShortName()+"(\""+property+"\");");
		getMethod.addBodyLine("return this.get" + getReturnMethodName(field) + "(\"" + property + "\");");
		topLevelClass.addMethod(getMethod);
		System.out.println("*****************\n");
	}

	/**
	 * 从json对象中获取值方法拼接
	 * 
	 * @param field
	 * @return
	 */
	private String getReturnMethodName(Field field) {
		FullyQualifiedJavaType field_type = field.getType();
		String shortName = field_type.getShortName();
		if (shortName.equals("byte[]")) {
			return "Bytes";
		} else {
			return shortName;
		}
	}

	private void generateToString1(IntrospectedTable introspectedTable,
			TopLevelClass topLevelClass) {
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.setName("toString"); //$NON-NLS-1$
		if (introspectedTable.isJava5Targeted()) {
			method.addAnnotation("@Override"); //$NON-NLS-1$
		}

		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);

		method.addBodyLine("StringBuilder sb = new StringBuilder();"); //$NON-NLS-1$
		method.addBodyLine("sb.append(getClass().getSimpleName());"); //$NON-NLS-1$
		method.addBodyLine("sb.append(\" [\");"); //$NON-NLS-1$
		method.addBodyLine("sb.append(\"Hash = \").append(hashCode());"); //$NON-NLS-1$
		StringBuilder sb = new StringBuilder();

		for (Field field : topLevelClass.getFields()) {
			String property = field.getName();
			String columnName = property.replaceFirst(property.substring(0, 1), property.substring(0, 1).toUpperCase());

			sb.setLength(0);
			sb.append("sb.append(\"").append(", ").append(property) //$NON-NLS-1$ //$NON-NLS-2$
					//.append("=\")").append(".append(").append(property) //$NON-NLS-1$ //$NON-NLS-2$
					.append("=\")").append(".append(").append("this.get" + columnName + "()") //$NON-NLS-1$ //$NON-NLS-2$
					.append(");"); //$NON-NLS-1$
			method.addBodyLine(sb.toString());
		}

		method.addBodyLine("sb.append(\"]\");"); //$NON-NLS-1$
		method.addBodyLine("return sb.toString();"); //$NON-NLS-1$

		topLevelClass.addMethod(method);
	}

	public boolean modelGetterMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable,
			Plugin.ModelClassType modelClassType) {
		return false;
	}

	public boolean modelSetterMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable,
			Plugin.ModelClassType modelClassType) {
		return false;
	}

}