package generator.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.TableConfiguration;

/**
 * 生成mybatis xml条件语句，这里目前只支持单表的条件生成，多表关联的条件需要自己添加
 * 
 * @author ql
 *
 */
public class SqlColumnPlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {

		// System.out.println(introspectedTable.getAllColumns());;
		TableConfiguration cfg = introspectedTable.getTableConfiguration();

		introspectedTable.getAllColumns();

		StringBuffer sb = new StringBuffer();
		int count = 0;
		for (IntrospectedColumn intColumn : introspectedTable.getAllColumns()) {
			// System.out.println(intColumn);
			String actualColumnName = intColumn.getActualColumnName();
			String javaProperty = intColumn.getJavaProperty();
			String jdbcTypeName = intColumn.getJdbcTypeName();

			System.out.println("getActualColumnName:\t" + actualColumnName);
			System.out.println("javaProperty:\t" + javaProperty);
			System.out.println("jdbcTypeName:\t" + jdbcTypeName);

			if (sb.length() > 0) {
				sb.append("," + actualColumnName);
			} else {
				sb.append(actualColumnName);
			}
//			if (count == 10) {
//				count = 0;
//				sb.append("\n");
//			}
			count++;
		}
		System.out.println(sb);
		XmlElement element = new XmlElement("sql"); //$NON-NLS-1$
		Attribute attribute = new Attribute("id", "base_column");
		element.addAttribute(attribute);

		String sql_columns = sb.toString();
		sql_columns = sql_columns.substring(0, sql_columns.length() -1);
		element.addElement(new TextElement(sb.toString()));

		context.getCommentGenerator().addComment(element);
		document.getRootElement().addElement(element);
		return true;
	}

}