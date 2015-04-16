package socialcode.service;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import socialcode.model.Image;
import socialcode.repository.ImageRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Service("ImageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    public Image save(MultipartFile file) throws IOException {
        BufferedImage src = null;
        src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
        // needs to be changed
        String id = "";
        id += new Random().nextInt(1000000);
        id += "_";
        id += new Date().getTime();
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "images");
        if (!dir.exists())
            dir.mkdirs();
        File destination = new File(dir.getAbsolutePath() + File.separator + id);
        ImageIO.write(src, "png", destination);
        String url = "/img/" + id;
        Image image = new Image();
        image.setImageLocation(destination.getAbsolutePath());
        imageRepository.save(image);
        return image;
    }

    public Image findById(int id) {
        Image image = imageRepository.findOne(id);
        return image;
    }

    public String imageSrc(Image image) throws IOException {
        String imgSrc = image.getImageLocation();
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext();
        Resource resource = appContext.getResource("file:" + imgSrc);
        BufferedImage img = ImageIO.read(resource.getFile());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        byte[] encode = Base64.encodeBase64(imageInByte);
        String imgStr = new String(encode);
        baos.close();
        return imgStr;
    }
}
