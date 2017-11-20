package com.micro.service.core.filter;//package com.spring.boot.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RestfulRequestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (request instanceof HttpServletRequest) {
            request = new RepeatedlyReadRequestWrapper((HttpServletRequest) request);
        }

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

//	public String inputStreamToString(InputStream in) throws IOException {
//		StringBuffer out = new StringBuffer();
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//		char[] charBuffer = new char[4096];
//		for (int n; (n = bufferedReader.read(charBuffer)) != -1;) {
//			out.append(new String(charBuffer, 0, n));
//		}
//		return out.toString();
//	}
//	private DelegatingServletInputStream stringToInputStream(String str) throws IOException {
//		ByteArrayOutputStream bo = new ByteArrayOutputStream();
//		ObjectOutputStream oo = new ObjectOutputStream(bo);
//		oo.writeObject(str);
//		return new DelegatingServletInputStream(new ByteArrayInputStream(bo.toByteArray()));
//	}

}
