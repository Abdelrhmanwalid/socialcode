package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import socialcode.model.Image;
import socialcode.service.ImageService;

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
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        Image image = imageService.save(file);
        int id = image.getId();
        String url = "/img/" + id;
        return "redirect:" + url;
    }

    @RequestMapping(value = "/img/{id}", method = RequestMethod.GET)
    public String img(ModelMap modelMap, @PathVariable("id") int id) throws IOException {
        Image image = imageService.findById(id);
        String imgStr = imageService.imageSrc(image);
        modelMap.addAttribute("img", imgStr);
        return "img";
    }

}
