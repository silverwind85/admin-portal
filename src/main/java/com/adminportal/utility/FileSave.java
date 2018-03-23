package com.adminportal.utility;

import com.adminportal.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Getter
@Component
public class FileSave {

    @Value("${path.img}")
    private String path;


    public  void  save(byte[] bytes,String name ){

        try {

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                    new File(path+name)));
            stream.write((bytes));
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
