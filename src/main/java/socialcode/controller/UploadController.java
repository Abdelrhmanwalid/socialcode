package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import socialcode.model.Image;
import socialcode.service.ImageService;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class UploadController {

	@Autowired
	ImageService imageService;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView uploadPage() {
		return new ModelAndView("upload");
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IOException {
		String path = request.getSession().getServletContext().getRealPath("");
		Image image = imageService.save(file, path);
		int id = image.getId();
		String url = "/img/" + id;
		return "redirect:" + url;
	}

	@RequestMapping(value = "/img/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String viewImg(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
			return "<img src=/vimg/" + id + " \\>";
	}

	@RequestMapping(value = "/vimg/{id}", method = RequestMethod.GET)
	public void img(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
		try {
			String path = request.getSession().getServletContext().getRealPath("");
			System.out.println(path);
			File file = imageService.getImage(id);
			MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
			String contentType = mimeTypesMap.getContentType(file);
			response.setContentType(contentType);
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			FileCopyUtils.copy(new FileInputStream(file),
					response.getOutputStream());
		} catch (IOException ignored) {
		}
	}

}
