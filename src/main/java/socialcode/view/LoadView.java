package socialcode.view;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.InternalResourceView;

public class LoadView extends InternalResourceView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String dispatcherPath = prepareForRendering(request, response);

		if(dispatcherPath.substring(
				dispatcherPath.lastIndexOf("/") + 1).equalsIgnoreCase("register")){
			System.out.println("222222222222222222222222222222222");
		}
		
		request.setAttribute("partial", dispatcherPath.substring(
				dispatcherPath.lastIndexOf("/") + 1));
		
		
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/WEB-INF/views/template.jsp");
		
		requestDispatcher.include(request, response);

	}
	
}