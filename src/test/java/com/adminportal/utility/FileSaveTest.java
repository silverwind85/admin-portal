package com.adminportal.utility;

import com.adminportal.domain.Product;
import com.adminportal.service.impl.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileSaveTest {

    @Autowired
    private FileSave fileSave;


    @Test
    public void testFileSave() throws Exception {
        //Given
        MockMultipartFile file = new MockMultipartFile("test"
                , "test.png"
                , "image/png",
                "content_test".getBytes());

        Product product = new Product("test", new BigDecimal("12"), 2.00);
        product.setImage(file);
        //When
        fileSave.save(product.getImage().getBytes(),product.getId()+".png");
        //Then
        String path = "src/main/resources/static/img/product/";
        File fileDelete = new File(path + "null.png");
        assertTrue(fileDelete.delete());
    }

}