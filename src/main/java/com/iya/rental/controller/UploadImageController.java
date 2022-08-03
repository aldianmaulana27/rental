package com.iya.rental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iya.rental.domain.entity.Image;
import com.iya.rental.domain.repository.ImageRepository;
import com.iya.rental.dto.result.ImageResponse;
import com.iya.rental.dto.result.ImageUploadResponse;
import com.iya.rental.service.ImageService;
import com.iya.rental.util.ImageUtility;

@RestController
//@CrossOrigin(origins = "http://localhost:8082") open for specific port
@CrossOrigin() // open for all ports
public class UploadImageController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ImageService imageService;

    @PostMapping("/upload/image")
    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file,@RequestParam("name") String name, @RequestParam("type") String type )throws IOException {

        String res = imageService.add(file, name , type);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse(res +
                        file.getOriginalFilename()));
    }

    @PostMapping("/upload/imageProduct")
    public ResponseEntity<ImageUploadResponse> uplaodImageProduct(@RequestParam("image") MultipartFile file,@RequestParam("name") String name, @RequestParam("type") String type ,@RequestParam("productId") String productId )throws IOException {

        String res = imageService.addImageProduct(file, name , type,productId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse(res +
                        file.getOriginalFilename()));
    }

    @GetMapping(path = {"/get/image/info"})
    public Image getImageDetails(@RequestParam("name") String name) throws IOException {

        Image res = imageService.getImageInfo(name);

        return Image.builder()
                .name(res.getName())
                .type(res.getType())
                .category(res.getCategory()).build();
    }

    @GetMapping(path = {"/get/imageAll"})
    public List<ImageResponse> getImageDetails(HttpServletRequest request) throws IOException { 
        String host = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort();
        System.out.println(host);
        List<ImageResponse> res = imageService.getAllImages(host);
            
        return res;
    }

    @GetMapping(path = {"/get/image/{uuid}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("uuid") String uuid) throws IOException {

        Image res = imageService.getImage(uuid);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(res.getType()))
                .body(ImageUtility.decompressImage(res.getImage()));
    }
    
    @GetMapping(path = {"/get/image-category"})
    public List<ImageResponse> getImageByCategory(HttpServletRequest request, @RequestParam("category") String category) throws IOException {
        String host = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort();
        System.out.println(host);
        List<ImageResponse> res = imageService.getImageCategory(host, category);
        return res;
    }
}