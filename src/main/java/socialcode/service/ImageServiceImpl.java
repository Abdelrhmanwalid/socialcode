package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.web.multipart.MultipartFile;
import socialcode.model.Image;
import socialcode.repository.ImageRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("ImageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    public Image save(MultipartFile file, String path) throws IOException {
        InputStream is;
        FileOutputStream os;
        Image image = new Image();
        try {
            is = file.getInputStream();
            MimeType type = MimeType.valueOf(file.getContentType());

            String extension = type.getSubtype();

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String name = "socialcode" + "_" + timeStamp;
            String location = path + "//" + name + "." + extension;
            os = new FileOutputStream(location);
            int read;
            byte b[] = new byte[1024];
            while ((read = is.read(b)) != -1) {
                os.write(b, 0, read);
            }
            is.close();
            os.close();
            image.setImageLocation(location);
            imageRepository.save(image);
        } catch (IOException ignored) {
        }
        return image;
    }

    public Image findById(int id) {
        return imageRepository.findOne(id);
    }

    public File getImage(int id){
        Image image = imageRepository.findOne(id);
        return new File(image.getImageLocation());
    }
}
