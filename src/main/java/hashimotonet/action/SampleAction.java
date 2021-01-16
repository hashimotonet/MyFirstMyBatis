/**
 *
 */
package hashimotonet.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashimotonet.bean.SampleBean;

/**
 * @author hashi
 *
 */
public class SampleAction {

		public boolean process(HttpServletRequest req, HttpServletResponse res, ServletContext sc, List<Map<String, Object>> param) throws ServletException, IOException {

			boolean result = false;
			SampleBean bean = new SampleBean();
			List<SampleBean> list = new ArrayList<SampleBean>();

			for(Map<String, Object> map : param) {
				bean.setId((int)map.get("id"));
				bean.setName((String)map.get("name"));
				list.add(bean);
				bean = new SampleBean();
			}

			req.setAttribute("list", list);

			RequestDispatcher rd = sc.getRequestDispatcher("/response.jsp");
			rd.forward(req, res);

			return false;
		}
}
