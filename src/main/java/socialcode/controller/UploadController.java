package socialcode.controller;

import org.apache.commons.codec.binary.Base64;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadPage(){
        return new ModelAndView("upload");
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        System.out.println(file.getName());
        BufferedImage src = null;
        try {
            src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            // needs to be changed
            String id = "1";
            String rootPath = System.getProperty("catalina.home");
            File dir = new File(rootPath + File.separator + "images");
            if (!dir.exists())
                dir.mkdirs();
            File destination = new File(dir.getAbsolutePath() + File.separator + id);
            ImageIO.write(src, "png", destination);
            String url = "/img/" + id;
            return "redirect:" + url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @RequestMapping(value = "/img/{id}", method = RequestMethod.GET)
    public String img(ModelMap modelMap, @PathVariable("id") String id) throws IOException {
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "images");
        File image = new File(dir.getAbsolutePath() + File.separator + id);

        ApplicationContext appContext =
                new ClassPathXmlApplicationContext();
        Resource resource = appContext.getResource("file:" + image);
        BufferedImage img = ImageIO.read(resource.getFile());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( img, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        byte[] encode = Base64.encodeBase64(imageInByte);
        String imgStr = new String(encode);
        baos.close();
        modelMap.addAttribute("img", imgStr);
        return "img";
    }

}
