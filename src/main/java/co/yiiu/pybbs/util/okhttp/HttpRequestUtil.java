package co.yiiu.pybbs.util.okhttp;

import org.apache.commons.lang3.StringUtils;

public class HttpRequestUtil {
	
	public static String getVersionSource(String userAgent,int type) {
		//1 取ios或者android  2 取version
		if(StringUtils.isEmpty(userAgent)) {
			return "";
		}
		String low = userAgent.toLowerCase();
		String source = getSource(low);
		if(1 == type) {
			return source;
		}
		if(2 == type) {
			if(!StringUtils.isEmpty(source)) {
				String[] ua = userAgent.split(" ");
				if(ua.length > 1) {
					String[] va = ua[0].split("/");
					if(va.length > 1) {
						return va[1];
					}
				}
			}
			return "";
		}
		
		return "";
	}
	
	
	public static String getSource(String low) {
		if(low.contains("ios")) {
			return "1";
		}
		if(low.contains("android")) {
			return "2";
		}
		return "";
	}
	
	public static String getChannel(String userAgent) {
		if(StringUtils.isBlank(userAgent)) {
			return StringUtils.EMPTY;
		}
		
		if(!userAgent.contains("channel")) {
			return StringUtils.EMPTY;
		}
		
		return userAgent.substring(userAgent.indexOf("channel") + 7 ).replaceAll("/", "").trim();
	}
	
	
//	public static void main(String[] args) {
//		String userAgent = "qiuhuiapp/2.1.7 (PCGM00;android 9;) channel/baidu";
//		
//		String version = HttpRequestUtil.getVersionSource(userAgent, 2);
//		String source = HttpRequestUtil.getVersionSource(userAgent, 1);
//		String channel = HttpRequestUtil.getChannel(userAgent);
//		
//		System.out.println("version       " + version);
//		System.out.println("source      " + source);
//		System.out.println("channel      " + channel);
//	}

	
}
