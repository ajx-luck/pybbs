/*
 * @Project Name: info-service
 * @File Name: FreemarkerUtil.java
 * @Package Name: com.hhly.sns.info.util
 * @Date: 2016年12月30日下午3:07:11
 * @Creator: tanshen-519
 * @line------------------------------
 * @修改人:
 * @修改时间:
 * @修改内容:
 */

package co.yiiu.pybbs.util;


import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Random;

/**
 * @description freemaker生成静态html文件工具类
 * @author tanshen-519
 * @date 2016年12月30日下午3:07:11
 * @see
 */
@Component
public class FreemarkerUtil {

	public final static String ARTICLE_HTML_PATH = "sport/article/h";
	private Logger LOG = LoggerFactory.getLogger(FreemarkerUtil.class);
	private Configuration cfg;

	@PostConstruct
	public void init() {
		// 临时文件存放目录
		cfg = new Configuration(Configuration.VERSION_2_3_22);
		// cfg.setClassForTemplateLoading(this.getClass(), "template");
		cfg.setNumberFormat("#");
		cfg.setTemplateExceptionHandler(new TemplateExceptionHandler() {

			@Override
			public void handleTemplateException(TemplateException arg0, Environment arg1, Writer arg2)
					throws TemplateException {
				LOG.error("生成模版文件的时候，参数为空：", arg0);
			}
		});
	}

	/**
	 * @description 生成freemaker静态html文件
	 * @date 2016年12月30日下午5:55:17
	 * @author tanshen-519
	 * @since 1.0.0
	 * @param file
	 * @param map
	 * @param overflag 是否覆盖保存
	 * @param filename 文件名
	 * @return
	 */
	public String transforFreemarker(File file, Map<String, Object> map, boolean overflag, String filename) {
		String url = "";
		File tempFile = null;
		Template temp = null;
		String overDir = "";
		try {
			// 设置获取模板的路径
			cfg.setDirectoryForTemplateLoading(file.getParentFile());
			// 获取模板
			 temp = cfg.getTemplate(file.getName());
			// temp.process(map, out);

			if (StringUtils.isBlank(filename)) {
				filename = StringUtils.join(getFileName(), ".html");
			} else {
				// 通过解析，获取文件名
				int start = filename.lastIndexOf("/");
				// 解析原有目录，以日期开头为准 /f/去掉
				overDir = filename.substring(filename.indexOf("/", 1) + 1, start == -1 ? 0 : start);
				filename = filename.substring(start == -1 ? 0 : (start + 1), filename.length());
			}
			tempFile = new File(System.getProperty("java.io.tmpdir"), filename);
		}catch (Exception ex) {
			LOG.error("生成freemaker静态html文件出错：{}", ex.getMessage());
		}
		try(FileOutputStream fos = new FileOutputStream(tempFile);
			Writer out = new OutputStreamWriter(fos);){
			temp.process(map, out);
			out.flush();
			LOG.info("生成freemaker静态html文件: {}",tempFile.getAbsolutePath());
			// 上传到文件服务器
//			if (overflag) {
//				url = FSUtil.uploadFile2FSWithOverride(tempFile, overDir);
//			} else {
//				url = FSUtil.uploadFile2FS(tempFile, getFilePathPrefix());
//			}
//			// 上传完成之后删除本地服务器上面的临时文件
//			tempFile.delete();

		}catch (Exception e) {
			LOG.error("生成freemaker静态html文件出错：{}", e.getMessage(), e);
		}
		return url;
	}

	public String getFilePathPrefix() {
		return ARTICLE_HTML_PATH;
	}

	public String getFileName() {
		return generator(16);
	}

	/**
	 * @description 生成随机文件名
	 * @date 2016年12月30日下午4:54:11
	 * @author tanshen-519
	 * @since 1.0.0
	 * @param length
	 * @return
	 */
	private String generator(int length) {
		String sources = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int codesLen = sources.length();
		Random rand = new Random(System.currentTimeMillis());
		StringBuilder verifyCode = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
		}
		return verifyCode.toString();
	}
}
