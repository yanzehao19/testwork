package yzh.freeMarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class Test {

	public static void main(String[] args) throws Exception {

		/*
		 * ---------------------------------------------------------------------
		 * ---
		 */
		/* You should do this ONLY ONCE in the whole application life-cycle: */

		/* Create and adjust the configuration singleton */
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		cfg.setDirectoryForTemplateLoading(new File("E:/Source/freeMarker/src/template"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);

		/*
		 * ---------------------------------------------------------------------
		 * ---
		 */
		/*
		 * You usually do these for MULTIPLE TIMES in the application
		 * life-cycle:
		 */

		/* Create a data-model */
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("user", "Big Joe11112222");
		Product latest = new Product();
		latest.setUrl("products/greenmouse.html");
		latest.setName("green mouse");
		root.put("latestProduct", latest);

		/* Get the template (uses cache internally) */
		Template temp = cfg.getTemplate("test.ftlh");

		/* Merge data-model with template */
		File outFile = new File("D:/outFile.html");
		FileOutputStream fos = new FileOutputStream(outFile);
		OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");

		Writer out = null;
		out = new BufferedWriter(oWriter);

		temp.process(root, out);
		// Note: Depending on what `out` is, you may need to call `out.close()`.
		// This is usually the case for file output, but not for servlet output.
	}
}
