package com.example.supermarket.ljy.web

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author jleo
 * @date 2020/4/29
 */
@RestController
@RequestMapping(value = "/image")
class ImageController {

    @RequestMapping(value = "/person")
    void getPersonalImage(HttpServletRequest request,
                          HttpServletResponse response) {
        def session = request.getSession()
        String value
        if (session != null) {
            value = session.getAttribute("stu_num")
        } else {
            value = "default"
        }
        def fis
        try {
            fis = new FileInputStream(new File("images/person/" + (value ?: "default") + ".jpg"))
        } catch (IOException e) {
            fis = new FileInputStream(new File("images/person/" + "default" + ".jpg"))
        }
        int len = 0
        response.setContentType("multipart/form-data")
        def out = response.getOutputStream()
        byte[] buffer = new byte[1024 * 10];
        while ((len = fis.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
        out.flush()
    }

    @RequestMapping(value = "/commodity")
    void getCommodityImage(@RequestParam(value = "cnum", required = false) String value,
                           HttpServletResponse response) {
        "".equals(value) ? value = "default" : value
        def fis
        try {
            fis = new FileInputStream(new File("images/commodity/" + (value ?: "default") + ".jpg"))
        } catch (IOException e) {
            fis = new FileInputStream(new File("images/commodity/" + "default" + ".jpg"))
        }
        int len = 0
        response.setContentType("multipart/form-data")
        def out = response.getOutputStream()
        byte[] buffer = new byte[1024 * 10];
        while ((len = fis.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
        out.flush()
    }

    @RequestMapping(value = "/update/person")
    boolean updatePersonalImage(MultipartFile file,
                                HttpServletRequest request) {
        def session = request.getSession()
        if (session == null) {
            return false
        }
        if (file.isEmpty()) {
            return false
        }
        String name = session.getAttribute("stu_num")
        if (name == null) {
            return false
        }
        String outputFile="images/person/"+name+".jpg"
        File outFile = new File(outputFile)
        outFile.createNewFile()
        def out = new FileOutputStream(outFile)
        out.write(file.getBytes())
        out.flush()
        out.close()
        return true
    }

    @PostMapping(value = "/update/commodity")
    boolean updateCommodityImage(@RequestBody MultipartFile file,
                                 @RequestParam(value = "cnum") String value) {
        if (value == null || value == "") {
            return false
        }
        if (file.isEmpty()) {
            return false
        }
        String outputFile="images/commodity/"+value+".jpg"
        File outFile = new File(outputFile)
        outFile.createNewFile()
        def out = new FileOutputStream(outFile)
        out.write(file.getBytes())
        out.flush()
        out.close()
        return true
    }

}
